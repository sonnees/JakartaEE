package vn.edu.iuh.fit.test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.repositories.DBConnect;

public class Mapping {
    public static void main(String[] args) {
        EntityManager en = DBConnect.getInstance().getEmf().createEntityManager();

        en.close();
    }
}
