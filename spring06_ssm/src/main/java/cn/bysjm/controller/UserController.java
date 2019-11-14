package cn.bysjm.controller;

import cn.bysjm.domain.User;
import cn.bysjm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/user")
@SessionAttributes("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login(User user, Model model) {
        User login = userService.login(user);
        if (login == null) {
            model.addAttribute("error", "用户名或密码错误");
            return "login";
        }
        model.addAttribute("user", user);
        return "redirect:/index.jsp";
    }

}
