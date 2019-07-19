package pyz.work.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pyz.work.service.Service;

public class springTest {
    //test测试类
    @Test
    public void run1(){
    /*加载applicationcontext.xml文件*/
        ApplicationContext ac=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        /*获取对象*/
        Service as= (Service) ac.getBean("service");
        as.hello();
    }
}
