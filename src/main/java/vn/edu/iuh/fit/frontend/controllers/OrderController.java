package vn.edu.iuh.fit.frontend.controllers;

import lombok.AllArgsConstructor;
import org.aspectj.lang.annotation.Around;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StreamUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.edu.iuh.fit.backend.dto.ProductDTO;
import vn.edu.iuh.fit.backend.models.*;
import vn.edu.iuh.fit.backend.repositories.*;
import vn.edu.iuh.fit.backend.services.OrderService;
import vn.edu.iuh.fit.backend.services.ProductService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/order")
@AllArgsConstructor
public class OrderController {
    ProductService productService;
    ProductRepository productRepository;
    CustomerRepository customerRepository;
    EmployeeRepository employeeRepository;
    OrderDetailRepository orderDetailRepository;
    OrderRepository orderRepository;
    OrderService orderService;

    @GetMapping("/by")
    public String getPageProduct(Model model,
                                 @RequestParam("page") Optional<Integer> page,
                                 @ModelAttribute("order") Optional<Order> order
                                 ){
        int listOrderDetail_size = 0;
        List<OrderDetail> orderTemp = new ArrayList<>();
        double totalPrice = 0.0;
        if(order.orElse(null) !=null){
            order.orElse(new Order()).getOrderDetails().forEach(i-> {
               if(i.getProduct().getProduct_id()!=0){
                   orderTemp.add(
                           new OrderDetail(
                                   i.getQuantity(),
                                   i.getPrice(),
                                   "",
                                   order.orElse(new Order()),
                                   productRepository.findById(Long.parseLong(i.getProduct().getProduct_id() + "")).orElse(new Product())
                           )
                   );
               }
            });
            listOrderDetail_size = orderTemp.size();

            List<OrderDetail> orderTemp2 = new ArrayList<>();
            if(!orderTemp.isEmpty()){
                for(int i = 0; i< 100;i++){
                    if(orderTemp.size()>i)
                        orderTemp2.add(orderTemp.get(i));
                    else orderTemp2.add(new OrderDetail());
                }
                order.get().setOrderDetails(orderTemp2);
            }


        }


        for(OrderDetail orderDetail : orderTemp){
            totalPrice += orderDetail.getPrice()*orderDetail.getQuantity();
        }

        PageRequest pageable = PageRequest.of(page.orElse(0), 10, Sort.by("name"));
        Page<ProductDTO> products = productService.getProduct(pageable);

        List<Integer> pages = Arrays.stream(IntStream.range(1,
                (productRepository.findAll().size()%10==0?productRepository.findAll().size()/10:productRepository.findAll().size()/10+1)+1
                ).toArray()).boxed().toList();

        List<Customer> customers = customerRepository.findAll();
        List<Employee> employees = employeeRepository.findAll();


        model.addAttribute("listOrderDetail_size", listOrderDetail_size);
        model.addAttribute("customers", customers);
        model.addAttribute("employees", employees);
        model.addAttribute("products", products);
        model.addAttribute("pages", pages);
        model.addAttribute("order", order.orElse(new Order()));
        model.addAttribute("orderTemp", orderTemp);
        model.addAttribute("totalPrice", totalPrice);



        return "client/home";
    }

    @PostMapping("/by")
    public String byProduct(Model model,
                            @ModelAttribute("order") Order order,
                            @RequestParam("page") Optional<Integer> page,
                            RedirectAttributes redirectAttributes
    ){

        if(page.isPresent()){
            redirectAttributes.addFlashAttribute("order", order);
            return "redirect:/order/by?page="+page.orElse(0);
        }

        order.setEmployee(employeeRepository.findById(order.getCustomer().getId()).orElse(new Employee()));
        order.setCustomer(customerRepository.findById(order.getCustomer().getId()).orElse(new Customer()));

        Order orderSaveTemp = new Order(
                LocalDateTime.of(9999,1,1,1,1,1),
                order.getEmployee(),
                order.getCustomer()
        );

        orderRepository.save(orderSaveTemp);
        Order orderSave = orderService.getOrderByDate();

        orderSave.setOrderDate(LocalDateTime.now());
        orderRepository.save(orderSave);

        for(OrderDetail orderDetail : order.getOrderDetails()){
            if(orderDetail.getProduct().getProduct_id()!=0){

                OrderDetail orderDetail1 = new OrderDetail(
                        orderDetail.getQuantity(),
                        orderDetail.getPrice(),
                        "",
                        orderSave,
                        productRepository.findById(orderDetail.getProduct().getProduct_id()).orElse(new Product())
                );

                orderDetailRepository.save(orderDetail1);

            }
        }

        return "redirect:/order/by";
    }
}
