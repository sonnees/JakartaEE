import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import vn.edu.iuh.fit.repositories.DBConnect;

public class Mapping {
    public static void main(String[] args) {
        EntityManager en = DBConnect.getInstance().getEmf().createEntityManager();
        EntityTransaction tr = en.getTransaction();
        try {
            tr.begin();

            tr.commit();
        } catch (Exception e){
            tr.rollback();
        }
    }
}
