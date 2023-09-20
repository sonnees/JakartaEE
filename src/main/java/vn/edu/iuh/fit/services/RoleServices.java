package vn.edu.iuh.fit.services;

import vn.edu.iuh.fit.entities.Role;
import vn.edu.iuh.fit.repositories.RoleDao;

import java.util.List;

public class RoleServices {
    private static vn.edu.iuh.fit.repositories.RoleDao RoleDao = new RoleDao();
    public static  void insertRole(Role role){
        RoleDao.insertRole(role);
    }
    public static List<Role> getRoles(){return RoleDao.getRoles();}
}
