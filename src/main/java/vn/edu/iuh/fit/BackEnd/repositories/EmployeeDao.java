package vn.edu.iuh.fit.BackEnd.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.BackEnd.enums.EmployeeStatus;
import vn.edu.iuh.fit.BackEnd.models.Employee;

import java.time.LocalDateTime;
import java.util.List;

public class EmployeeDao {
    private EntityManager em= null;
    Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public EmployeeDao() {
        this.em = DBConnect.getInstance().getEmf().createEntityManager();
    }

    public List<Employee> getAll() {
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();

            List<Employee> list = em.createNativeQuery("SELECT * from employee ORDER BY full_name where status = 2 OR status = 1", Employee.class).getResultList();

            tr.commit();
            return list;
        } catch (Exception e) {
            logger.info(e.getMessage());
            tr.rollback();
        }
        return null;
    }


    public Employee searchById(long id){
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();

            Employee employee = em.find(Employee.class, id);

            tr.commit();
            return employee;
        } catch (Exception e){
            logger.info(e.getMessage());
            tr.rollback();
        }
        return null;
    }


    public List<Employee> getFromXToY(int x, int y){
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();

            int from = y-x+1;
            int to = x-1;

            String sql = "SELECT * FROM employee ORDER BY full_name where status = 2 OR status = 1 LIMIT "+from +" OFFSET "+to;

            List<Employee> list = em.createNativeQuery(sql, Employee.class).getResultList();

            tr.commit();
            return list;
        } catch (Exception e){
            logger.info(e.getMessage());
            tr.rollback();
        }
        return null;
    }

    public boolean add(Employee employee){
        EntityTransaction tr = em.getTransaction();
        Employee temp = searchById(employee.getId());
        try {
            tr.begin();

            em.merge(employee);

//            if(temp!=null){
//                em.merge(product);
//            }
//            else{
//                em.persist(product);
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
        Employee employee = searchById(id);
        if(employee==null) return false;
        try {
            tr.begin();
            switch (nameField){
                case "address":
                    employee.setAddress(newValue);
                    break;
                case "dob":
                    LocalDateTime dateTime = LocalDateTime.parse(newValue);
                    employee.setDob(dateTime);
                    break;
                case "email":
                    employee.setEmail(newValue);
                    break;
                case "full_name":
                    employee.setFullName(newValue);
                    break;
                case "phone":
                    employee.setPhone(newValue);
                    break;
                case "status":
                    if (newValue.equals("-1")) {
                        employee.setStatus(EmployeeStatus.terminal);
                    } else if (newValue.equals("0")){
                        employee.setStatus(EmployeeStatus.noActive);
                    } else employee.setStatus(EmployeeStatus.active);
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
        Employee employee = searchById(id);
        if(employee==null) return false;
        try {
            tr.begin();

            employee.setStatus(EmployeeStatus.terminal);

            tr.commit();
            return true;
        } catch (Exception e){
            logger.info(e.getMessage());
            tr.rollback();
        }
        return false;
    }

}
