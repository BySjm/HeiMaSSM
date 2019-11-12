package cn.bysjm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TargetController {

    @RequestMapping("/target")
    public String target(){
        System.out.println("目标方法执行了！！");
        return "success";
    }

}
