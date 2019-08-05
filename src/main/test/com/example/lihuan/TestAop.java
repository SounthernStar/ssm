package com.example.lihuan;

import com.example.lihuan.service.AccountService;
import com.example.lihuan.service.impl.AccountServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:aop/aop-config.xml")
public class TestAop
{
    @Resource(name = "accountService")
    private AccountService accountService;
    @Test
    public void run()
    {
        accountService.findAll();
    }
}
