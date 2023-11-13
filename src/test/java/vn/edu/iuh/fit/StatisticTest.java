package vn.edu.iuh.fit;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import vn.edu.iuh.fit.backend.dto.Statistic2Field;
import vn.edu.iuh.fit.backend.dto.Statistic2Field_Money;
import vn.edu.iuh.fit.backend.mapping.Statistic2FieldMap;
import vn.edu.iuh.fit.backend.mapping.Statistic2Field_MoneyMap;
import vn.edu.iuh.fit.backend.repositories.CustomerRepository;
import vn.edu.iuh.fit.backend.repositories.EmployeeRepository;
import vn.edu.iuh.fit.backend.repositories.OrderRepository;
import vn.edu.iuh.fit.backend.repositories.ProductRepository;
import vn.edu.iuh.fit.backend.services.ProductService;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
public class StatisticTest {
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
    @Autowired
    Statistic2FieldMap statistic2FieldMap;
    @Autowired
    Statistic2Field_MoneyMap statistic2FieldMoneyMap;

    @Test
    void statisticDayInMonth(){

        List<Object[]> objects = orderRepository.statisticDayInMonth(LocalDateTime.now());
        List<Statistic2Field> statistic2Fields = statistic2FieldMap.to(objects);
        System.out.println(statistic2Fields);
    }

    @Test
    void statisticMonthInYear(){

        List<Object[]> objects = orderRepository.statisticMonthInYear(LocalDateTime.now());
        List<Statistic2Field> statistic2Fields = statistic2FieldMap.to(objects);
        System.out.println(statistic2Fields);
    }

    @Test
    void statisticDayInMonth_Money(){

        List<Object[]> objects = orderRepository.statisticDayInMonth_Money(LocalDateTime.now());
        List<Statistic2Field_Money> statistic2Fields = statistic2FieldMoneyMap.to(objects);
        System.out.println(statistic2Fields);
    }

    @Test
    void statisticMonthInYear_Money(){

        List<Object[]> objects = orderRepository.statisticMonthInYear_Money(LocalDateTime.now());
        List<Statistic2Field_Money> statistic2Fields = statistic2FieldMoneyMap.to(objects);
        System.out.println(statistic2Fields);
    }
}
