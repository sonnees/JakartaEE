package vn.edu.iuh.fit.test;

import vn.edu.iuh.fit.entities.Account;
import vn.edu.iuh.fit.services.AccountServices;

public class AccountServices_test {
    public static void main(String[] args) {

        Account account1 = new Account("met","Tran Thi Met","123","met@gmail.com","0904567890",(byte) 1);
        Account account2 = new Account("teo","Nguyen Van Teo","123","teo@gmail.com","0903123456",(byte) 1);

        AccountServices.insertAccount(account1);
        AccountServices.insertAccount(account2);

        AccountServices.getAccounts().forEach(i-> System.out.println(i));
    }
}
