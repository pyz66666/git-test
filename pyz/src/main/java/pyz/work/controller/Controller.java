package pyz.work.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pyz.work.daomain.Account;
import pyz.work.service.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@org.springframework.stereotype.Controller
@RequestMapping("/mvc")
public class Controller {

    @Autowired
    private Service service;

    @RequestMapping("/move")
    public String find(Model model){
        System.out.println("success");
        service.hello();
        List<Account> list=service.findAll();
        model.addAttribute("list",list);
        return "list";
    }
    @RequestMapping("/save")
    public void save(Account account, HttpServletRequest request, HttpServletResponse response) throws IOException {
        service.saveAccounts(account);
        response.sendRedirect(request.getContextPath()+"/mvc/move");
        return ;
    }
}
