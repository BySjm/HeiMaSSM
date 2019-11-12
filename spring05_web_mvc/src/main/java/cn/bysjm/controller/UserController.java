package cn.bysjm.controller;

import cn.bysjm.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@SessionAttributes("app")
public class UserController {

    @RequestMapping("/quick")
    public String quickMethod(){
        int a = 1/0;
        return "success";
    }

    @RequestMapping("/returnString")
    public String quick(@SessionAttribute("app") String app){
        System.out.println(app);
        return "success";
    }
    @RequestMapping("/returnVoid")
    public void returnVoid(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //直接通过response响应数据
        /*response.getWriter().write("hello...");*/
        //请求转发
        request.setAttribute("app","app");
        request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response);
        //重定向
        //response.sendRedirect(request.getContextPath()+"/index.jsp");
    }
    @RequestMapping("/returnModelAndView1")
    public ModelAndView returnModelAndView1(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("app","value");
        modelAndView.setViewName("success");
        return modelAndView;
    }
    @RequestMapping("/returnModelAndView2")
    public ModelAndView returnModelAndView2(ModelAndView modelAndView){
        modelAndView.addObject("app","value");
        modelAndView.setViewName("success");
        return modelAndView;
    }
    @RequestMapping("/forward")
    public String forward(Model model){
        model.addAttribute("app","jackChen");
        return "success";
//        return "forward:/index.jsp";
    }
    @RequestMapping("/redirect")
    public String redirect(Model model){
        model.addAttribute("username","艾伦~");
        return "redirect:/index.jsp";
    }
    /*@RequestMapping("/ajaxRequest")
    @ResponseBody
    public void ajaxRequest(@RequestBody String body){
        System.out.println(body);
    }*/
    @RequestMapping("/ajaxRequest")
    @ResponseBody
    public List<User> ajaxRequest(@RequestBody List<User> list){
        System.out.println(list);
        return list;
    }
    //文件长传
    @RequestMapping("/fileUpload")
    public String fileUpload(String username, MultipartFile[] picFile) throws IOException {
        System.out.println(username);
        for (MultipartFile multipartFile : picFile) {
            String filename = multipartFile.getOriginalFilename();
            System.out.println(filename);
            multipartFile.transferTo(new File("D:\\Development\\upload\\"+filename));
        }
        return "success";
    }
}
