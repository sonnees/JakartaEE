package vn.edu.iuh.fit.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.enums.ProductStatus;
import vn.edu.iuh.fit.models.Customer;
import vn.edu.iuh.fit.models.Product;

import java.util.List;

public class CustomerDao {

    private EntityManager em= null;
    Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public CustomerDao() {
        this.em = DBConnect.getInstance().getEmf().createEntityManager();
    }

    public List<Customer> getAll() {
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();

            List<Customer> list = em.createNativeQuery("SELECT * from customer order by cust_name", Customer.class).getResultList();

            tr.commit();
            return list;
        } catch (Exception e) {
            logger.info(e.getMessage());
            tr.rollback();
        }
        return null;
    }


    public Customer searchById(long id){
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();

            Customer customer = em.find(Customer.class, id);

            tr.commit();
            return customer;
        } catch (Exception e){
            logger.info(e.getMessage());
            tr.rollback();
        }
        return null;
    }


    public List<Customer> getFromXToY(int x, int y){
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();

            int from = y-x+1;
            int to = x-1;

            String sql = "SELECT * FROM customer ORDER BY cust_name LIMIT "+from +" OFFSET "+to;

            List<Customer> list = em.createNativeQuery(sql, Customer.class).getResultList();

            tr.commit();
            return list;
        } catch (Exception e){
            logger.info(e.getMessage());
            tr.rollback();
        }
        return null;
    }

    public boolean add(Customer customer){
        EntityTransaction tr = em.getTransaction();
        Customer temp = searchById(customer.getId());
        try {
            tr.begin();

            em.merge(customer);

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
        Customer customer = searchById(id);
        if(customer==null) return false;
        try {
            tr.begin();
            switch (nameField){
                case "name":
                    customer.setName(newValue);
                    break;
                case "email":
                    customer.setEmail(newValue);
                    break;
                case "phone":
                    customer.setPhone(newValue);
                    break;
                case "address":
                    customer.setAddress(newValue);
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
        Customer customer = searchById(id);
        if(customer==null) return false;
        try {
            tr.begin();

            em.remove(customer);

            tr.commit();
            return true;
        } catch (Exception e){
            logger.info(e.getMessage());
            tr.rollback();
        }
        return false;
    }


}
