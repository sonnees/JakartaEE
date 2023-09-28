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

    public List<Product> getAll() {
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();

            List<Product> list = em.createNativeQuery("SELECT * from product where status = 2 OR status = 1 ORDER BY name", Product.class).getResultList();

            tr.commit();
            return list;
        } catch (Exception e) {
            logger.info(e.getMessage());
            tr.rollback();
        }
        return null;
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


    public List<Product> getFromXToY(int x, int y){
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();

            int from = y-x+1;
            int to = x-1;

            String sql = "SELECT * FROM product  where status = 2 OR status = 1 ORDER BY name LIMIT "+from +" OFFSET "+to;

            List<Product> list = em.createNativeQuery(sql, Product.class).getResultList();

            tr.commit();
            return list;
        } catch (Exception e){
            logger.info(e.getMessage());
            tr.rollback();
        }
        return null;
    }

    public boolean add(Product product){
        EntityTransaction tr = em.getTransaction();
        Product temp = searchById(product.getId());
        try {
            tr.begin();

            em.merge(product);

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
        Product product = searchById(id);
        if(product==null) return false;
        try {
            tr.begin();
            switch (nameField){
                case "name":
                    product.setName(newValue);
                    break;
                case "description":
                    product.setDescription(newValue);
                    break;
                case "unit":
                    product.setUnit(newValue);
                    break;
                case "manufacturer":
                    product.setManufacturer(newValue);
                    break;
                case "status":
                    if (newValue.equals("-1")) {
                        product.setStatus(ProductStatus.terminal);
                    } else if (newValue.equals("0")){
                        product.setStatus(ProductStatus.noActive);
                    } else product.setStatus(ProductStatus.active);
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
        Product product = searchById(id);
        if(product==null) return false;
        try {
            tr.begin();

            product.setStatus(ProductStatus.terminal);

            tr.commit();
            return true;
        } catch (Exception e){
            logger.info(e.getMessage());
            tr.rollback();
        }
        return false;
    }


}
