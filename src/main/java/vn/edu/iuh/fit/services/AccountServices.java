package vn.edu.iuh.fit.services;

import vn.edu.iuh.fit.entities.Account;
import vn.edu.iuh.fit.repositories.AccountDao;

import java.util.List;

public class AccountServices {
    private static AccountDao accountDao = new AccountDao();
    public static  void insertAccount(Account account){
        accountDao.insertAccount(account);
    }
    public static List<Account> getAccounts(){return accountDao.getAccounts();}
}
