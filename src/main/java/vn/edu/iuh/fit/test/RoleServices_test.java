package vn.edu.iuh.fit.test;

import vn.edu.iuh.fit.entities.Role;
import vn.edu.iuh.fit.services.RoleServices;

public class RoleServices_test {
    public static void main(String[] args) {
        Role role1 = new Role("admin","administrator","admin role",(byte)1);
        Role role2 = new Role("user","user","user role",(byte)1);

        RoleServices.insertRole(role1);
        RoleServices.insertRole(role2);
        RoleServices.getRoles().forEach(i-> System.out.println(i));
    }
}
