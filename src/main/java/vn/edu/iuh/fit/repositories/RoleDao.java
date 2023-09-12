package vn.edu.iuh.fit.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import vn.edu.iuh.fit.entities.Role;

import java.util.List;

public class RoleDao {
    private EntityManager em;

    public RoleDao() {
        em = DbConnect.getInstance().getEmf().createEntityManager();
    }

    public void insertRole(Role role){
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try {
            em.persist(role);
            tr.commit();
        } catch (Exception e){
            tr.rollback();
            System.out.println(e.getMessage());
        }
    }

    public List<Role> getRoles(){
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try {
            String sql ="select * from role";
            List<Role> rl = em.createNativeQuery(sql, Role.class).getResultList();

            tr.commit();
            return rl;
        } catch (Exception e){
            tr.rollback();
            System.out.println(e.getMessage());
        }
        return null;
    }
}
