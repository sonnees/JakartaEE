package vn.edu.iuh.fit.repositories;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DbConnect {
    private static DbConnect instance;
    private EntityManagerFactory emf;

    private  DbConnect() {
        try {
            emf = Persistence.createEntityManagerFactory("persistence01");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static DbConnect getInstance() {
        if(instance == null)
            instance = new DbConnect();
        return instance;
    }

    public EntityManagerFactory getEmf() {
        return emf;
    }
}
