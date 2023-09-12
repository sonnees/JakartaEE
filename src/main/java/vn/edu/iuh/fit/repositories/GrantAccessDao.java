package vn.edu.iuh.fit.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import vn.edu.iuh.fit.entities.GrantAccess;
import vn.edu.iuh.fit.entities.Role;

import java.util.List;

public class GrantAccessDao {
    private EntityManager em;

    public GrantAccessDao() {
        em = DbConnect.getInstance().getEmf().createEntityManager();
    }

    public void insertGrantAccess(GrantAccess grantAccess){
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try {
            System.out.println(grantAccess);
            em.persist(grantAccess);
            tr.commit();
        } catch (Exception e){
            tr.rollback();
            System.out.println(e.getMessage());
        }
    }

    public List<GrantAccess> getListGrantAccess(){
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try {
            String sql ="select * from grant_access";
            List<GrantAccess> rl = em.createNativeQuery(sql, GrantAccess.class).getResultList();

            tr.commit();
            return rl;
        } catch (Exception e){
            tr.rollback();
            System.out.println(e.getMessage());
        }
        return null;
    }
}
