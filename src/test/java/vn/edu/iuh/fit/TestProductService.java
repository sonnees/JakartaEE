package vn.edu.iuh.fit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import vn.edu.iuh.fit.backend.dto.ProductDTO;
import vn.edu.iuh.fit.backend.models.Order;
import vn.edu.iuh.fit.backend.repositories.CustomerRepository;
import vn.edu.iuh.fit.backend.repositories.EmployeeRepository;
import vn.edu.iuh.fit.backend.repositories.OrderRepository;
import vn.edu.iuh.fit.backend.repositories.ProductRepository;
import vn.edu.iuh.fit.backend.services.ProductService;

import java.time.LocalDateTime;
import java.util.Optional;

@SpringBootTest
public class TestProductService {
    @Autowired
    ProductService productService;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    CustomerRepository customerRepository;

    @Test
    void getProduct(){
        Pageable pageable = PageRequest.of(0, 10, Sort.by("name"));
        Page<ProductDTO> product = productService.getProduct(pageable);
        product.forEach(i-> System.out.println(i.getName()));
        Assertions.assertNotNull(product);
    }

    @Test
    void more(){
        Order orderSaveTemp = new Order(
                LocalDateTime.of(9999,1,1,1,1,1),
                employeeRepository.findById(1L).orElse(null),
                customerRepository.findById(1L).orElse(null)
        );
        orderRepository.save(orderSaveTemp);


    }

    @Test
    void more1(){
        LocalDateTime minDateTime = LocalDateTime.MIN;

        System.out.println("Minimum LocalDateTime: " + minDateTime);

    }
}
