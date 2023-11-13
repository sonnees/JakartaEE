package vn.edu.iuh.fit.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vn.edu.iuh.fit.backend.models.Order;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query(value = "select * from ORDERS where ORDER_DATE = '9999-01-01 01:01:01.000000'",nativeQuery = true)
    Order getOrderByDate();
    @Query(
            value = "SELECT FORMATDATETIME(order_date, 'yyyy-MM-dd') AS date, " +
                    "       COUNT(order_id) AS quantity " +
                    "FROM PUBLIC.ORDERS " +
                    "WHERE FORMATDATETIME(order_date, 'yyyy-MM') = FORMATDATETIME(:date, 'yyyy-MM') " +
                    "GROUP BY date " +
                    "ORDER BY date",
            nativeQuery = true)
    List<Object[]> statisticDayInMonth(LocalDateTime date);

    @Query(
            value = "SELECT FORMATDATETIME(order_date, 'yyyy-MM') AS date, " +
                    "       COUNT(order_id) AS quantity " +
                    "FROM PUBLIC.ORDERS " +
                    "WHERE FORMATDATETIME(order_date, 'yyyy') = FORMATDATETIME(:date, 'yyyy') " +
                    "GROUP BY date " +
                    "ORDER BY date",
            nativeQuery = true)
    List<Object[]> statisticMonthInYear(LocalDateTime date);

    @Query(
            value = "SELECT FORMATDATETIME(o.ORDER_DATE, 'yyyy-MM-dd') AS date, sum(case when OD.ORDER_ID then totalO else 0 end) as totalD " +
                    "                    FROM PUBLIC.ORDERS o " +
                    "                    left join (select ORDER_ID, sum(case when ORDER_ID then PRICE*QUANTITY else 0 end) as totalO from ORDER_DETAIL " +
                    "                                        group by ORDER_ID " +
                    "                                        ) OD on o.ORDER_ID = OD.ORDER_ID " +
                    "                    WHERE FORMATDATETIME(order_date, 'yyyy-MM') = FORMATDATETIME(:date, 'yyyy-MM') " +
                    "                    GROUP BY date " +
                    "                    ORDER BY date",
            nativeQuery = true)
    List<Object[]> statisticDayInMonth_Money(LocalDateTime date);

    @Query(
            value = "SELECT FORMATDATETIME(o.ORDER_DATE, 'yyyy-MM') AS date, sum(case when OD.ORDER_ID then totalO else 0 end) as totalD " +
                    "                    FROM PUBLIC.ORDERS o " +
                    "                    left join (select ORDER_ID, sum(case when ORDER_ID then PRICE*QUANTITY else 0 end) as totalO from ORDER_DETAIL " +
                    "                                        group by ORDER_ID " +
                    "                                        ) OD on o.ORDER_ID = OD.ORDER_ID " +
                    "                    WHERE FORMATDATETIME(order_date, 'yyyy') = FORMATDATETIME(:date, 'yyyy') " +
                    "                    GROUP BY date " +
                    "                    ORDER BY date",
            nativeQuery = true)
    List<Object[]> statisticMonthInYear_Money(LocalDateTime date);
}