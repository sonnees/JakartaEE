package vn.edu.iuh.fit.test;

import vn.edu.iuh.fit.repositories.OrderDao;

import java.time.LocalDateTime;
import java.util.Map;

public class Orders_test {
    public static void main(String[] args) {
        OrderDao orderDao = new OrderDao();
        Map<String, Integer> analDay = orderDao.getAnalDay(LocalDateTime.parse("2023-09-21T15:45"));
        analDay.entrySet().forEach(i->{
            System.out.println(i.getKey() +" | " + i.getValue());
        });
    }
}
