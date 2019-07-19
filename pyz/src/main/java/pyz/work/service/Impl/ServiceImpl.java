package pyz.work.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import pyz.work.dao.Dao;
import pyz.work.daomain.Account;
import pyz.work.service.Service;

import java.util.List;

@org.springframework.stereotype.Service("service")
public class ServiceImpl implements Service {

    @Autowired
    private Dao dao;


    @Override
    public void hello() {
        System.out.println("Hello world");
    }

    public List<Account> findAll(){
            return dao.find();
    }

    @Override
    public void saveAccounts(Account account) {
        dao.saveAccount(account);
    }
}
