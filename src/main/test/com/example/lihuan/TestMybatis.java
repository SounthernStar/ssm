package com.example.lihuan;

import com.example.lihuan.dao.AccountDao;
import com.example.lihuan.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class TestMybatis
{
    @Test
    public void run1() throws IOException
    {
        //加载配置文件
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        //创建SqlSession对象
        SqlSession session = factory.openSession();
        //获取代理对象
        AccountDao dao = session.getMapper(AccountDao.class);
        List<Account> list = dao.findAll();
        for(Account a:list)
            System.out.println(a);
        //关闭资源
        session.close();
        is.close();
    }

    @Test
    public void run2() throws IOException
    {
        //加载配置文件
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        //创建SqlSession对象
        SqlSession session = factory.openSession();
        //获取代理对象
        AccountDao dao = session.getMapper(AccountDao.class);
        Account ac = new Account();
        ac.setName("zhangsan");
        ac.setMoney(12.0);
        dao.saveAccount(ac);
        session.commit();
        //关闭资源
        session.close();
        is.close();
    }
}
