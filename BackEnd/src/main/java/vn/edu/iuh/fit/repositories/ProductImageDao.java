package vn.edu.iuh.fit.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.enums.ProductStatus;
import vn.edu.iuh.fit.models.Product;
import vn.edu.iuh.fit.models.ProductImage;

import java.util.List;

public class ProductImageDao {

    private EntityManager em= null;
    Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    private ProductDao productDao = new ProductDao();
    public ProductImageDao() {
        this.em = DBConnect.getInstance().getEmf().createEntityManager();
    }

    public List<ProductImage> getAll() {
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();

            List<ProductImage> list = em.createNativeQuery("SELECT * from product_image", ProductImage.class).getResultList();

            tr.commit();
            return list;
        } catch (Exception e) {
            logger.info(e.getMessage());
            tr.rollback();
        }
        return null;
    }


    public ProductImage searchById(long id){
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();

            ProductImage productImage = em.find(ProductImage.class, id);

            tr.commit();
            return productImage;
        } catch (Exception e){
            logger.info(e.getMessage());
            tr.rollback();
        }
        return null;
    }

    public boolean add(ProductImage productImage){
        EntityTransaction tr = em.getTransaction();
        ProductImage temp = searchById(productImage.getId());
        try {
            tr.begin();

            em.merge(productImage);

//            if(temp!=null){
//                em.merge(productImage);
//            }
//            else{
//                em.persist(productImage);
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
        ProductImage productImage = searchById(id);
        if(productImage==null) return false;
        try {
            tr.begin();
            switch (nameField){
                case "path":
                    productImage.setPath(newValue);
                    break;
                case "alternative":
                    productImage.setAlternative(newValue);
                    break;
                case "product":
                    productImage.setProduct(productDao.searchById(Long.parseLong(newValue)));
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
        System.out.println(id);
        ProductImage productImage = searchById(id);
        if(productImage==null) return false;
        try {
            tr.begin();

            em.remove(productImage);

            tr.commit();
            return true;
        } catch (Exception e){
            logger.info(e.getMessage());
            tr.rollback();
        }
        return false;
    }

}
