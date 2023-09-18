package vn.edu.iuh.fit.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.models.Product;
import vn.edu.iuh.fit.models.ProductPrice;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ProductPriceDao {
    private EntityManager em;
    Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public ProductPriceDao() {
        this.em = DBConnect.getInstance().getEmf().createEntityManager();
    }

    public boolean addProductPrice(ProductPrice productPrice){
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

    public boolean delProductPrice(long productId,LocalDateTime priceDateTime){
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();

            ProductPrice productPrice = new ProductPrice(priceDateTime,em.find(Product.class,productId));
            em.remove(this.searchProductPriceById(productId,priceDateTime));

            tr.commit();
            return true;
        } catch (Exception e){
            logger.info(e.getMessage());
            tr.rollback();
        }
        return false;
    }

    public ProductPrice searchProductPriceById(long productId,LocalDateTime priceDateTime){
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();

            ProductPrice productPriceId = new ProductPrice(priceDateTime,em.find(Product.class,productId));
            ProductPrice productPrice = em.find(ProductPrice.class, productPriceId);

            tr.commit();
            return productPrice;
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

            List<ProductPrice> list = em.createNativeQuery("findAll", ProductPrice.class).getResultList();

            tr.commit();
            return list;
        } catch (Exception e){
            logger.info(e.getMessage());
            tr.rollback();
        }
        return null;
    }



}
