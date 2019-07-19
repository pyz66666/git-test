package pyz.work.service;

import pyz.work.daomain.Account;

import java.util.List;

public interface Service {

    public void hello();

    public List<Account> findAll();

    public void saveAccounts(Account account);
}
