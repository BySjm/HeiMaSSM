package cn.bysjm.controller;

import cn.bysjm.domain.Account;
import cn.bysjm.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService service;

    @RequestMapping("/findAll")
    public String findAll(Model model){
        List<Account> list = service.findAll();
        model.addAttribute("list",list);
        return "list";
    }

}
