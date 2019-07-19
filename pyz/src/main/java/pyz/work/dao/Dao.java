package pyz.work.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import pyz.work.daomain.Account;

import java.util.List;

@Repository
public interface Dao {
    //查询所有账户
    @Select("select * from account")
    public List<Account> find();
    //保存账户信息
    @Insert("insert into account (name,money) values (#{name},#{money})")
    public void saveAccount(Account account);


}
