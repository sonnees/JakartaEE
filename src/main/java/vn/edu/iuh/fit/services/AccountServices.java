package vn.edu.iuh.fit.services;

import vn.edu.iuh.fit.entities.Account;
import vn.edu.iuh.fit.entities.GrantAccess;
import vn.edu.iuh.fit.entities.Role;
import vn.edu.iuh.fit.repositories.AccountDao;
import vn.edu.iuh.fit.repositories.GrantAccessDao;
import vn.edu.iuh.fit.repositories.RoleDao;

import java.util.List;

public class AccountServices {
    private static AccountDao accountDao = new AccountDao();
    public static  void insertAccount(Account account){
        accountDao.insertAccount(account);

        RoleDao roleDao = new RoleDao();
        Role role = new Role("user", "user role", "", (byte) 1);
        roleDao.insertRole(role);

        GrantAccessDao grantAccessDao = new GrantAccessDao();
        GrantAccess grantAccess = new GrantAccess(true, "", account, role);
        grantAccessDao.insertGrantAccess(grantAccess);

    }
    public static Account searchAccount(String id){return accountDao.searchAccount(id);}
    public static void dellAccount(String id){
        accountDao.dellAccount(id);
        GrantAccessDao grantAccessDao = new GrantAccessDao();
        grantAccessDao.delete(id);

    }
    public static List<Account> getAccounts(){return accountDao.getAccounts();}
}
