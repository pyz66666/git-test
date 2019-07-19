package pyz.work.test;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import pyz.work.dao.Dao;
import pyz.work.daomain.Account;

import java.io.InputStream;
import java.util.List;


public class testmybatis {
    /**
     * 测试查询
     * @throws Exception
     */
    @Test
    public void run1() throws Exception{
        //加载配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建SqlSessionFactory对象
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(in);
        //创建sqlsession
        SqlSession session=factory.openSession();
        //获取代理对象
        Dao dao= session.getMapper(Dao.class);
        List<Account>  list=dao.find();
        for(Account account :list){
            System.out.println(account);
        }
        session.close();
        in.close();
    }

    /**
     * 测试保存
     * @throws Exception
     */
    @Test
    public void run2() throws Exception{
        Account account=new Account();
        account.setName("攀爬怕你");
        account.setMoney(455555.333);
        //加载配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建SqlSessionFactory对象
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(in);
        //创建sqlsession
        SqlSession session=factory.openSession();
        //获取代理对象
        Dao dao= session.getMapper(Dao.class);
        //保存
        dao.saveAccount(account);
        //提交事务
        session.commit();
        session.close();
        in.close();
    }
}
