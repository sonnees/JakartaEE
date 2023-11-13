package vn.edu.iuh.fit.frontend.controllers.client;

import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.edu.iuh.fit.backend.dto.OrderDetailDTO;
import vn.edu.iuh.fit.backend.dto.ProductDTO;
import vn.edu.iuh.fit.backend.models.*;
import vn.edu.iuh.fit.backend.repositories.*;
import vn.edu.iuh.fit.backend.services.OrderService;
import vn.edu.iuh.fit.backend.services.ProductService;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/home")
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
    public String getPageProduct(
            Model model,
            @RequestParam("page") Optional<Integer> page,
            HttpSession httpSession
    ){
        if(httpSession.getAttribute("size")==null)
            httpSession.setAttribute("size",0);

        PageRequest pageable = PageRequest.of(page.orElse(0), 10, Sort.by("name"));
        Page<ProductDTO> products = productService.getProduct(pageable);

        List<Integer> pages = Arrays.stream(IntStream.range(1,
                (productRepository.findAll().size()%10==0?productRepository.findAll().size()/10:productRepository.findAll().size()/10+1)+1
                ).toArray()).boxed().toList();


        model.addAttribute("products", products);
        model.addAttribute("pages", pages);
        model.addAttribute("curPage", (page.orElse(0))+1);
        model.addAttribute("size",Integer.parseInt(httpSession.getAttribute("size").toString()));
        return "client/home";
    }

    @PostMapping("/add")
    public String addToCart(
            Model model,
            HttpSession httpSession,
            @RequestParam("id") Long id,
            @RequestParam("price") Double price,
            @RequestParam("img") String img
    ){
        Object obj = httpSession.getAttribute("orderDetails");
        Map<Long, OrderDetailDTO> orderDetails = null;
        if(obj==null){
            orderDetails = new HashMap<>();
            httpSession.setAttribute("orderDetails",orderDetails);
        }
        else orderDetails =(Map<Long, OrderDetailDTO>) obj;

        Product product = productRepository.findById(id).get();

        if(!orderDetails.containsKey(id)){
            orderDetails.put(id,
                    new OrderDetailDTO(
                            id,img,product.getName(),price,1
                    ));
            httpSession.setAttribute("size",(Integer.parseInt(httpSession.getAttribute("size").toString())+1));
        }

        else orderDetails.replace(id,
                new OrderDetailDTO(
                        id,img,product.getName(),price,orderDetails.get(id).getQuantity()+1
                ));
        return "redirect:/home/by";
    }

    @GetMapping("/remove")
    public String reMoveToCart(
            Model model,
            HttpSession httpSession,
            @RequestParam("id") Long id
    ){
        Object obj = httpSession.getAttribute("orderDetails");
        if(obj==null)
            return "redirect:/home/by";

        Map<Long, OrderDetailDTO> orderDetails = (Map<Long, OrderDetailDTO>) httpSession.getAttribute("orderDetails");
        orderDetails.remove(id);

        httpSession.setAttribute("orderDetails",orderDetails);

        httpSession.setAttribute("size",(Integer.parseInt(httpSession.getAttribute("size").toString())-1));
        return "redirect:/home/cart";
    }

    @GetMapping("/cart")
    public String byProduct(
            Model model,
            HttpSession httpSession
    ){
        Map<Long, OrderDetailDTO> orderDetails = null;
        Object obj = httpSession.getAttribute("orderDetails");
        if(obj==null)
            return "redirect:/home/by";

        orderDetails = (Map<Long, OrderDetailDTO>) httpSession.getAttribute("orderDetails");

        List<Customer> customers = customerRepository.findAll();
        List<Employee> employees = employeeRepository.findAll();

        List<OrderDetailDTO> list = orderDetails.values().stream().toList();

        long totalP = 0L;
        for(OrderDetailDTO orderDetailDTO : list){
            totalP+= (long) (orderDetailDTO.getPriceP()*orderDetailDTO.getQuantity());
        }

        model.addAttribute("customers", customers);
        model.addAttribute("customer", new Customer());
        model.addAttribute("employees", employees);
        model.addAttribute("employee", new Employee());
        model.addAttribute("list", list);
        model.addAttribute("totalP", totalP);

        return "client/cart";
    }

    @PostMapping("/order")
    public String order(
            HttpSession httpSession,
            @ModelAttribute("employee") Employee employee,
            @ModelAttribute("customer") Customer customer
    ){
        if(customer.getId()==0)
            customer.setId(1);
        if(employee.getId()==0)
            employee.setId(1);

        Map<Long, OrderDetailDTO> orderDetails = null;
        Object obj = httpSession.getAttribute("orderDetails");
        if(obj==null)
            return "redirect:/home/by";

        orderDetails = (Map<Long, OrderDetailDTO>) httpSession.getAttribute("orderDetails");

        List<OrderDetailDTO> list = orderDetails.values().stream().toList();
        Customer cus = customerRepository.findById(customer.getId()).get();
        Employee emp = employeeRepository.findById(employee.getId()).get();

        Order orderSaveTemp = new Order(
                LocalDateTime.of(9999,1,1,1,1,1),
                emp,
                cus
        );

        orderRepository.save(orderSaveTemp);
        Order orderSave = orderService.getOrderByDate();

        orderSave.setOrderDate(LocalDateTime.now());
        for(OrderDetailDTO orderDetailDTO : list){
            orderDetailRepository.save(new OrderDetail(
                    orderDetailDTO.getQuantity(),
                    orderDetailDTO.getPriceP(),
                    "none",
                    orderSave,
                    productRepository.findById(orderDetailDTO.getIdP()).get()
            ));
        }
        orderRepository.save(orderSave);

        httpSession.removeAttribute("orderDetails");
        httpSession.removeAttribute("size");
        return "redirect:/home/by";
    }
}
