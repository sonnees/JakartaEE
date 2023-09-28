package vn.edu.iuh.fit.services;

import jakarta.inject.Inject;
import vn.edu.iuh.fit.models.Employee;
import vn.edu.iuh.fit.repositories.EmployeeDao;

import java.util.List;

public class EmployeeSer {
    @Inject
    private EmployeeDao dao;

    @Inject
    public EmployeeSer(EmployeeDao employeeDao) {
        this.dao = employeeDao;
    }

    public List<Employee> getAll(){
        return dao.getAll();
    }

    public Employee searchById(long id){
        return dao.searchById(id);
    }

    public List<Employee> getFromXToY(int x, int y){
        return dao.getFromXToY(x,y);
    };

    public boolean add(Employee employee){
        return dao.add(employee);
    }

    public boolean updateField(long id, String nameField, String newValue){
        return dao.updateField(id,nameField,newValue);
    }
    public boolean del(long id){
        return dao.del(id);
    }

}
