package vn.edu.iuh.fit.test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import vn.edu.iuh.fit.repositories.DbConnect;

public class ConnectDB_test {
    public static void main(String[] args) {
        try {
            DbConnect dbConnect = DbConnect.getInstance();
            EntityManager emf = dbConnect.getEmf().createEntityManager();

            EntityTransaction tr = emf.getTransaction();
            tr.begin();
            try {
                tr.commit();
            } catch (Exception e){
                tr.rollback();
                System.out.println(e.getMessage());
            }

            System.out.println("done");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
