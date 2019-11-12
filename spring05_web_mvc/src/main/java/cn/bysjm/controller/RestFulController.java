package cn.bysjm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//@Controller
@RestController
public class RestFulController {
    @RequestMapping(value = "/user", method = RequestMethod.POST)
//    @ResponseBody
    public String add(){
        return "add";
    }
    @RequestMapping(value = "/user", method = RequestMethod.PUT)
//    @ResponseBody
    public String update(){
        return "update";
    }
    @RequestMapping(value = "/user", method = RequestMethod.DELETE)
//    @ResponseBody
    public String delete(){
        return "delete";
    }
//    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    @GetMapping("/user/{id}")
//    @ResponseBody
    public String find(@PathVariable() Integer id){
        return "find:" + id;
    }
}
