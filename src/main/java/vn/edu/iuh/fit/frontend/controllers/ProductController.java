package vn.edu.iuh.fit.frontend.controllers;

import lombok.AllArgsConstructor;
import org.aspectj.lang.annotation.Around;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.backend.dto.ProductDTO;
import vn.edu.iuh.fit.backend.models.Customer;
import vn.edu.iuh.fit.backend.models.Employee;
import vn.edu.iuh.fit.backend.models.Order;
import vn.edu.iuh.fit.backend.models.OrderDetail;
import vn.edu.iuh.fit.backend.repositories.CustomerRepository;
import vn.edu.iuh.fit.backend.repositories.EmployeeRepository;
import vn.edu.iuh.fit.backend.repositories.ProductRepository;
import vn.edu.iuh.fit.backend.services.ProductService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/product")
@AllArgsConstructor
public class ProductController {
    ProductService productService;
    ProductRepository productRepository;
    CustomerRepository customerRepository;
    EmployeeRepository employeeRepository;
    @GetMapping("/by")
    public String getPageProduct(Model model,
                                 @RequestParam("page") Optional<Integer> page
                                 ){
        PageRequest pageable = PageRequest.of(page.orElse(0), 10, Sort.by("name"));
        Page<ProductDTO> products = productService.getProduct(pageable);

        List<Integer> pages = Arrays.stream(IntStream.range(1,
                (productRepository.findAll().size()%10==0?productRepository.findAll().size()/10:productRepository.findAll().size()/10+1)+1
                ).toArray()).boxed().toList();

        List<Customer> customers = customerRepository.findAll();
        List<Employee> employees = employeeRepository.findAll();

        Order order = new Order();
        model.addAttribute("listOrderDetail_size", 0);
        model.addAttribute("customers", customers);
        model.addAttribute("employees", employees);
        model.addAttribute("products", products);
        model.addAttribute("pages", pages);
        model.addAttribute("order", order);

        return "client/home";
    }

    @PostMapping("/by")
    public String byProduct(Model model,
                            @ModelAttribute("order") Order order

    ){
        order.setEmployee(employeeRepository.findById(order.getCustomer().getId()).orElse(new Employee()));
        order.setCustomer(customerRepository.findById(order.getCustomer().getId()).orElse(new Customer()));
        System.out.println(order);
        System.out.println(order.getOrderDetails().get(0).getProduct().getProduct_id());
//        orderDetails.forEach(i-> {
//            System.out.println("---");
//
//            System.out.println(i.getProduct().getName());
//            System.out.println(i.getPrice());
//            System.out.println(i.getQuantity());
//
//            System.out.println("---");
//        });

        return "redirect:/product/by";
    }
}
