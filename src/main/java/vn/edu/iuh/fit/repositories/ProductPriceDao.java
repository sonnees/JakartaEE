package vn.edu.iuh.fit.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.models.Product;
import vn.edu.iuh.fit.models.ProductPrice;

import java.time.LocalDateTime;
import java.util.List;

public class ProductPriceDao {
    private EntityManager em;
    Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    public ProductPriceDao() {em = DBConnect.getInstance().getEmf().createEntityManager();
    }

    public boolean add(ProductPrice productPrice){
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();

            em.merge(productPrice);

            tr.commit();
            return true;
        } catch (Exception e){
            logger.info(e.getMessage());
            tr.rollback();
        }
        return false;
    }

    public boolean del(long productId,LocalDateTime priceDateTime){
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();

            ProductPrice productPrice = new ProductPrice(priceDateTime,em.find(Product.class,productId));
            em.remove(this.searchById(productId,priceDateTime));

            tr.commit();
            return true;
        } catch (Exception e){
            logger.info(e.getMessage());
            tr.rollback();
        }
        return false;
    }

    public ProductPrice searchById(long productId,LocalDateTime priceDateTime){
        EntityTransaction tr = em.getTransaction();
        Product product = em.find(Product.class, productId);

        try {
            tr.begin();

//            ProductPrice productPrice = em.find(ProductPrice.class, productPriceID);

            tr.commit();
            return null;
        } catch (Exception e){
            logger.info(e.getMessage());
            tr.rollback();
        }
        return null;
    }

    public List<ProductPrice> getAll(){
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();

            List<ProductPrice> list = em.createNativeQuery("select * from product_price", ProductPrice.class).getResultList();

            tr.commit();
            return list;
        } catch (Exception e){
            logger.info(e.getMessage());
            tr.rollback();
        }
        return null;
    }

    public List<ProductPrice> getFromXToY(int x, int y){
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();

            int from = y-x+1;
            int to = x-1;

            String sql = "SELECT * FROM product_price  where status = 2 LIMIT "+from +" OFFSET "+to;

            List<ProductPrice> list = em.createNativeQuery(sql, ProductPrice.class).getResultList();

            tr.commit();
            return list;
        } catch (Exception e){
            logger.info(e.getMessage());
            tr.rollback();
        }
        return null;
    }
}
