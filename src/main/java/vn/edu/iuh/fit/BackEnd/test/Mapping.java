package vn.edu.iuh.fit.BackEnd.test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.BackEnd.repositories.DBConnect;

public class Mapping {
    public static void main(String[] args) {
        EntityManager en = DBConnect.getInstance().getEmf().createEntityManager();
        EntityTransaction tr = en.getTransaction();
        tr.begin();
        try {
            tr.commit();
        } catch (Exception e){
            tr.rollback();
        }

    }
}
