package vn.edu.iuh.fit;

import net.datafaker.Faker;
import net.datafaker.providers.base.BaseProviders;
import net.datafaker.providers.base.Brand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import vn.edu.iuh.fit.backend.enums.EmployeeStatus;
import vn.edu.iuh.fit.backend.enums.ProductStatus;
import vn.edu.iuh.fit.backend.models.*;
import vn.edu.iuh.fit.backend.repositories.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class ApplicationTests {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    OrderDetailRepository orderDetailRepository;
    @Autowired
    ProductPriceRepository productPriceRepository;
    Faker faker = new Faker();


    @Test
    void add() throws InterruptedException {
//        addProduct();
//        addEmployee();
//        addCustomer();
        addOrder();
    }

    private void addOrder() {
        for(int i =521; i<=600; i++){
            Order order = new Order(i,
                    LocalDateTime.of(
                            2023,
                            11,
                            faker.random().nextInt(1,13),
                            0,0,0
                    ),
                    employeeRepository.findById(faker.random().nextLong(1,10)).orElse(null),
                    customerRepository.findById(faker.random().nextLong(1,50)).orElse(null)
            );
            orderRepository.save(order);

            for(int j = 1; j<=3; j++){
                OrderDetail orderDetail = new OrderDetail(
                        faker.random().nextDouble(1,5),
                        faker.random().nextDouble(10000,1000000),
                        faker.device().modelName(),
                        order,
                        productRepository.findById(Long.parseLong(faker.random().nextLong(1,200)+"")).orElse(null)
                );
                orderDetailRepository.save(orderDetail);
            }
        }
    }

    private void addCustomer() {
        for(int i =1; i<=50; i++){
            Customer customer = new Customer(
                    faker.name().fullName(),
                    "%d@gmail.com".formatted(i),
                    faker.random().nextInt(100000000,900000000)+"",
                    faker.address().fullAddress()
            );
            customerRepository.save(customer);
        }
    }

    private void addEmployee() {
        for(int i =1; i<=10; i++){
            Employee employee = new Employee(
                    faker.name().fullName(),
                    LocalDate.now(), "%d@gmail.com".formatted(i),
                    faker.random().nextInt(100000000,900000000)+"",
                    faker.address().fullAddress(),
                    faker.random().nextInt() % 2 == 0 ? EmployeeStatus.ACTIVE : EmployeeStatus.IN_ACTIVE
            );
            employeeRepository.save(employee);

        }
    }

    private void addProduct() throws InterruptedException {
        for (int i= 1; i <= 200; i++) {
            Integer i1 = faker.random().nextInt(1, 3);
            Product product = new Product(
                    faker.brand().sport(),
                    faker.device().modelName(),
                    faker.random().nextInt()%2==0?"kg":"unit",
                    faker.device().manufacturer(),
                    i1%2==0?ProductStatus.ACTIVE:ProductStatus.IN_ACTIVE
            );

            productRepository.save(product);

            product.setProductImageList(
                    List.of(
                            new ProductImage(
                                    "https://th.bing.com/th/id/R.1aaa962e628166bc2b5961513c814511?rik=p40HD5BpEvm%2fsA&pid=ImgRaw&r=0",
                                    product)));

            List<ProductPrice> productPrices = new ArrayList<>();
            for(int j = 1; j<=3; j++){
                ProductPrice productPrice = new ProductPrice(
                        product, LocalDateTime.now(),faker.random().nextDouble(10000,1000000),faker.device().manufacturer()
                );
                TimeUnit.MICROSECONDS.sleep(50);
                productPrices.add(productPrice);
            }
            product.setProductPrices(productPrices);

            productRepository.save(product);
        }
    }

    @Test
    void find() {
    }
}
