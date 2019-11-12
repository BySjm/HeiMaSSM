package cn.bysjm.controller;

import cn.bysjm.domain.QueryVo;
import cn.bysjm.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping(value = "/quick", method = {RequestMethod.GET, RequestMethod.POST}, params = {"id", "username"})
    public String quick() {
        System.out.println("runner quick");
        return "success";
    }

    @RequestMapping("/simpleParam")
    public String simpleParam(Integer id, String username){
        System.out.println(id);
        System.out.println(username);
        return "success";
    }

    @RequestMapping("/pojoParam")
    public String method(User user){
        System.out.println(user);
        return "success";
    }

    @RequestMapping("/arrayParam")
    public String method(Integer[] ids){
        System.out.println(Arrays.toString(ids));
        return "success";
    }

    @RequestMapping("/queryVoParam")
    public String method(QueryVo queryVo){
        System.out.println(queryVo);
        return "success";
    }

    @RequestMapping("/converterParam")
    public String method(Date birthday){
//        System.out.println(birthday.toLocaleString());
        return "success";
    }

    @RequestMapping("/findByPage")
    public String method(@RequestParam(name = "pageNo", defaultValue = "1") String pageNumber,@RequestParam(defaultValue = "10") String pageSize){
        System.out.println(pageNumber);
        System.out.println(pageSize);
        return "success";
    }
    @RequestMapping("/requestHeader")
    public String method(@RequestHeader("User-Agent") String useragent){
        System.out.println(useragent);
        return "success";
    }
    @RequestMapping("/cookieValue")
    public String cookieValue(@CookieValue("JSESSIONID") String jsessionid){
        System.out.println(jsessionid);
        return "success";
    }

    @RequestMapping("/servletAPI")
    public void servletAPI(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
        System.out.println(request);
        System.out.println(response);
        System.out.println(session);
        request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response);
    }

}
