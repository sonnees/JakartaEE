package vn.edu.iuh.fit.backend.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.backend.dto.Statistic2Field;
import vn.edu.iuh.fit.backend.dto.Statistic2Field_Money;
import vn.edu.iuh.fit.backend.mapping.Statistic2FieldMap;
import vn.edu.iuh.fit.backend.mapping.Statistic2Field_MoneyMap;
import vn.edu.iuh.fit.backend.models.Order;
import vn.edu.iuh.fit.backend.repositories.OrderRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class OrderService {
    OrderRepository orderRepository;
    Statistic2FieldMap statistic2FieldMap;
    Statistic2Field_MoneyMap statistic2FieldMoneyMap;
    public Order getOrderByDate(){
        return orderRepository.getOrderByDate();
    }
    public List<Statistic2Field> statisticDayInMonth(LocalDateTime date){
        List<Object[]> objects = orderRepository.statisticDayInMonth(date);
        return statistic2FieldMap.to(objects);
    }

    public List<Statistic2Field> statisticMonthInYear(LocalDateTime date){
        List<Object[]> objects = orderRepository.statisticMonthInYear(date);
        return statistic2FieldMap.to(objects);
    }

    public List<Statistic2Field_Money> statisticDayInMonth_Money(LocalDateTime date){
        List<Object[]> objects = orderRepository.statisticDayInMonth_Money(date);
        return statistic2FieldMoneyMap.to(objects);
    }

    public List<Statistic2Field_Money> statisticMonthInYear_Money(LocalDateTime date){
        List<Object[]> objects = orderRepository.statisticMonthInYear_Money(date);
        return statistic2FieldMoneyMap.to(objects);
    }
}
