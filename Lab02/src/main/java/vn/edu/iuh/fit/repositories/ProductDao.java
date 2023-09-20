package vn.edu.iuh.fit.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.enums.ProductStatus;
import vn.edu.iuh.fit.models.Product;

import java.util.List;

public class ProductDao {

    private EntityManager em= null;
    Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public ProductDao() {
        this.em = DBConnect.getInstance().getEmf().createEntityManager();
    }

    public boolean add(Product product){
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();

            em.merge(product);

            tr.commit();
            return true;
        } catch (Exception e){
            logger.info(e.getMessage());
            tr.rollback();
        }
        return false;
    }

    public boolean del(long id){
        Product product = this.searchById(id);

        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();

            if(product!=null){
                product.setStatus(ProductStatus.terminal);
                return true;
            }

            tr.commit();
        } catch (Exception e){
            logger.info(e.getMessage());
            tr.rollback();
        }
        return false;
    }

    public Product searchById(long id){
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();

            Product product = em.find(Product.class, id);

            tr.commit();
            return product;
        } catch (Exception e){
            logger.info(e.getMessage());
            tr.rollback();
        }
        return null;
    }

    public List<Product> getAll(){
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();

            List<Product> list = em.createNativeQuery("SELECT * from product where status = 2", Product.class).getResultList();

            tr.commit();
            return list;
        } catch (Exception e){
            logger.info(e.getMessage());
            tr.rollback();
        }
        return null;
    }

    public List<Product> getFromXToY(int x, int y){
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();

            int from = y-x+1;
            int to = x-1;

            String sql = "SELECT * FROM product  where status = 2 LIMIT "+from +" OFFSET "+to;

            List<Product> list = em.createNativeQuery(sql, Product.class).getResultList();

            tr.commit();
            return list;
        } catch (Exception e){
            logger.info(e.getMessage());
            tr.rollback();
        }
        return null;
    }
}
