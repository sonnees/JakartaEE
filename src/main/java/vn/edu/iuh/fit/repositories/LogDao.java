package vn.edu.iuh.fit.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import vn.edu.iuh.fit.entities.Log;

import java.util.List;

public class LogDao {
    private EntityManager em;

    public LogDao() {
        em = DbConnect.getInstance().getEmf().createEntityManager();
    }

    public void insertLog(Log log){
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try {
            em.persist(log);
            tr.commit();
        } catch (Exception e){
            tr.rollback();
            System.out.println(e.getMessage());
        }
    }

    public List<Log> getLogs(){
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try {
            String sql ="select * from log";
            List<Log> rl = em.createNativeQuery(sql, Log.class).getResultList();

            tr.commit();
            return rl;
        } catch (Exception e){
            tr.rollback();
            System.out.println(e.getMessage());
        }
        return null;
    }
}
