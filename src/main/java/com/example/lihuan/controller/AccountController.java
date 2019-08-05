package com.example.lihuan.controller;


import com.example.lihuan.domain.Account;
import com.example.lihuan.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController
{
    @Autowired  //自动注入
    private AccountService accountService;

    @RequestMapping("save")
    @ResponseBody
    public Account save(Account account, HttpServletRequest request,HttpServletResponse response) throws IOException
    {
        accountService.saveAccount(account);
        //response.sendRedirect(request.getContextPath()+"/account/findAll");
        return account;
    }

    @RequestMapping("findAll")
    @ResponseBody
    public List<Account> findAll()
    {
        System.out.println("表现层：查询所用账户。。。");
        //调用service方法
        List<Account> list = accountService.findAll();
        return list;
    }

}
