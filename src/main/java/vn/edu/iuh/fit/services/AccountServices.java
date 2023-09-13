package vn.edu.iuh.fit.services;

import vn.edu.iuh.fit.entities.Account;
import vn.edu.iuh.fit.repositories.AccountDao;

import java.util.List;

public class AccountServices {
    private static AccountDao accountDao = new AccountDao();
    public static  void insertAccount(Account account){
        accountDao.insertAccount(account);
    }
    public static Account searchAccount(String id){return accountDao.searchAccount(id);}
    public static void dellAccount(String id){accountDao.dellAccount(id);}
    public static List<Account> getAccounts(){return accountDao.getAccounts();}
}
