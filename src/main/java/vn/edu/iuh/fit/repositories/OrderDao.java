package vn.edu.iuh.fit.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.enums.ProductStatus;
import vn.edu.iuh.fit.models.Orders;
import vn.edu.iuh.fit.models.Product;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderDao {
    private EntityManager em= null;
    Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    private CustomerDao customerDao = new CustomerDao();
    private EmployeeDao employeeDao = new EmployeeDao();
    public OrderDao() {
        this.em = DBConnect.getInstance().getEmf().createEntityManager();
    }

    public List<Orders> getAll() {
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();

            List<Orders> list = em.createNativeQuery("SELECT * from orders ORDER BY DESC order_date", Orders.class).getResultList();

            tr.commit();
            return list;
        } catch (Exception e) {
            logger.info(e.getMessage());
            tr.rollback();
        }
        return null;
    }


    public Orders searchById(long id){
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();

            Orders orders = em.find(Orders.class, id);

            tr.commit();
            return orders;
        } catch (Exception e){
            logger.info(e.getMessage());
            tr.rollback();
        }
        return null;
    }


    public List<Orders> getFromXToY(int x, int y){
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();

            int from = y-x+1;
            int to = x-1;

            String sql = "SELECT * FROM orders ORDER BY order_date DESC LIMIT "+from +" OFFSET "+to;

            List<Orders> list = em.createNativeQuery(sql, Orders.class).getResultList();

            tr.commit();
            return list;
        } catch (Exception e){
            logger.info(e.getMessage());
            tr.rollback();
        }
        return null;
    }

    public Map<String,Integer> getAnalDay(LocalDateTime localDateTime){
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();
            Map<String,Integer> map = new HashMap<>();
            String sql = "SELECT DATE_FORMAT(order_date, '%Y-%m-%d') AS date, COUNT(order_id) AS quantity " +
                    "FROM orders " +
                    "where DATE_FORMAT(order_date, '%Y-%m') = DATE_FORMAT('"+localDateTime.toString()+"', '%Y-%m') " +
                    "GROUP BY date;";
            List<Object[]> resultList = em.createNativeQuery(sql, Object.class).getResultList();
            System.out.println("1");
            for (Object[] i : resultList){
                String date = (String) i[0];
                int quantity = Integer.parseInt(i[1].toString());
                map.put(date,quantity);
            }
            tr.commit();
            return map;
        } catch (Exception e){
            logger.info(e.getMessage());
            tr.rollback();
        }
        return null;
    }

    public boolean add(Orders orders){
        EntityTransaction tr = em.getTransaction();
        Orders temp = searchById(orders.getId());
        try {
            tr.begin();

            em.merge(orders);

//            if(temp!=null){
//                em.merge(product);
//            }
//            else{
//                em.persist(product);
//            }

            tr.commit();
            return true;
        } catch (Exception e){
            logger.info(e.getMessage());
            tr.rollback();
        }
        return false;
    }

    public boolean updateField(long id, String nameField, String newValue){
        EntityTransaction tr = em.getTransaction();
        Orders orders = searchById(id);
        if(orders==null) return false;
        try {
            tr.begin();
            switch (nameField){
                case "orderDate":
                    orders.setOrderDate(LocalDateTime.parse(newValue));
                    break;
                case "employee":
                    orders.setEmployee(employeeDao.searchById(Long.parseLong(newValue)));
                    break;
                case "customer":
                    orders.setCustomer(customerDao.searchById(Long.parseLong(newValue)));
                    break;

            }
            tr.commit();
            return true;
        } catch (Exception e){
            logger.info(e.getMessage());
            tr.rollback();
        }
        return false;
    }

    public boolean del(long id){
        EntityTransaction tr = em.getTransaction();
        Orders orders = searchById(id);
        if(orders==null) return false;
        try {
            tr.begin();

            em.remove(orders);

            tr.commit();
            return true;
        } catch (Exception e){
            logger.info(e.getMessage());
            tr.rollback();
        }
        return false;
    }

}
