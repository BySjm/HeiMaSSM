package cn.bysjm.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor1 implements HandlerInterceptor {

    /**
     *
     * @param request
     * @param response
     * @param handler
     * @return        true放行，false拦截
     * @throws Exception
     */
    @Override
    // 在执行目标方法之前，拦截
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("MyInterceptor1执行了...");
        return true;
    }

    @Override
    // 在执行目标方法之后，增强
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("MyInterceptor1的postHandle");
    }

    @Override
    // 在所有流程执行完毕后，释放资源
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("MyInterceptor1的afterCompletion");
    }
}
