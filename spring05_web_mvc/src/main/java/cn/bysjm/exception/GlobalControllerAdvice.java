package cn.bysjm.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(Exception.class)
    public void handlerException(HttpServletRequest request, HttpServletResponse response, Exception ex){
        request.setAttribute("error",ex.getMessage());
        try {
            request.getRequestDispatcher(request.getContextPath() + "/error.jsp").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @ExceptionHandler(ArithmeticException.class)
    public String handlerException2(ArithmeticException aex, Model model){
        model.addAttribute("error",aex.getMessage()+"算法异常");
        return "forward:error.jsp";
    }

}
