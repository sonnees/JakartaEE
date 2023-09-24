package vn.edu.iuh.fit.BackEnd.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.BackEnd.models.Product;
import vn.edu.iuh.fit.BackEnd.models.ProductPrice;

import java.time.LocalDateTime;
import java.util.List;

public class ProductPriceDao {
    private EntityManager em;
    Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    public ProductPriceDao() {em = DBConnect.getInstance().getEmf().createEntityManager();
    }
    public ProductPrice searchById(ProductPrice id){
        EntityTransaction tr = em.getTransaction();

        try {
            tr.begin();

            ProductPrice productPrice = em.find(ProductPrice.class, id);

            tr.commit();
            return productPrice;
        } catch (Exception e){
            logger.info(e.getMessage());
            tr.rollback();
        }
        return null;
    }

    public List<ProductPrice> getAll(long id){
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();

            List<ProductPrice> list = em.createNativeQuery("select * from product_price where product_id = "+id+" order by price_date_time DESC", ProductPrice.class).getResultList();

            tr.commit();
            return list;
        } catch (Exception e){
            logger.info(e.getMessage());
            tr.rollback();
        }
        return null;
    }



    public List<ProductPrice> getFromXToY(long id, int x, int y){
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();

            int from = y-x+1;
            int to = x-1;

            String sql = "SELECT * FROM product_price  where product_id = "+id+" order by price_date_time DESC LIMIT "+from +" OFFSET "+to;

            List<ProductPrice> list = em.createNativeQuery(sql, ProductPrice.class).getResultList();

            tr.commit();
            if(list==null || list.size()==0)  return null;
            return list;
        } catch (Exception e){
            logger.info(e.getMessage());
            tr.rollback();
        }
        return null;
    }

    public boolean add(ProductPrice productPrice){
        EntityTransaction tr = em.getTransaction();
        ProductPrice id = new ProductPrice(productPrice.getPriceDateTime(),productPrice.getProduct());
        ProductPrice temp = searchById(id);
        try {
            tr.begin();
            if(temp!=null)
                em.merge(productPrice);
            else
                em.persist(productPrice);
            tr.commit();
            return true;
        } catch (Exception e){
            logger.info(e.getMessage());
            tr.rollback();
        }
        return false;
    }

    public boolean updateField(ProductPrice id, String nameField, String newValue){
        EntityTransaction tr = em.getTransaction();
        ProductPrice productPrice = searchById(id);
        System.out.println(productPrice);
        if (productPrice == null) return false;
        try {
            tr.begin();

            switch (nameField){
                case "note":
                    productPrice.setNote(newValue);
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

    public boolean del(ProductPrice id){
        EntityTransaction tr = em.getTransaction();
        ProductPrice productPrice = searchById(id);
        if(productPrice==null) return false;
        try {
            tr.begin();

            em.remove(productPrice);

            tr.commit();
            return true;
        } catch (Exception e){
            logger.info(e.getMessage());
            tr.rollback();
        }
        return false;
    }

}
