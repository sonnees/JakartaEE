package vn.edu.iuh.fit.BackEnd.repositories;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
public class DBConnect {
    private static DBConnect instance;
    private EntityManagerFactory emf;

    private DBConnect() {
        emf = Persistence.createEntityManagerFactory("Lab02");
    }

    public static DBConnect getInstance() {
        if(instance==null)
            instance = new DBConnect();
        return instance;
    }

    public EntityManagerFactory getEmf() {
        return emf;
    }
}
