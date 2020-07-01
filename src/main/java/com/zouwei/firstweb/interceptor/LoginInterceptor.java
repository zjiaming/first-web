package com.zouwei.firstweb.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zouwei.firstweb.utils.JWTUtils;
import com.zouwei.firstweb.utils.JsonData;
import io.jsonwebtoken.Claims;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * 登录拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {

    /**
     * 进去到controller之前的方法
     *
     * @param request
     * @param response
     * @param handler
     * @return true表示继续流程；false表示流程中断，不会继续调用其他的拦截器或处理器
     * @throws Exception
     *
     *
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try {
            //先从head里面取出token,如果head里面没有，则从参数里面获取
            String token = request.getHeader("token");
            if (StringUtils.isEmpty(token)) {
                token = request.getParameter("token");
            }

            //如果不为空的话，通过jwt解密
            if (StringUtils.isNotBlank(token)) {
                Claims claims = JWTUtils.checkJwt(token);
                if (claims == null) {
                    //登录失败了，或者是登录过期了，重新登录
                    sendJsonMessage(response, JsonData.buildError(500,"登录过期，重新登录"));
                    return false;
                }

                Integer id = (Integer) claims.get("id");
                String name = (String) claims.get("name");

                //设置这个，controller可以拿到
                request.setAttribute("user_id", id);
                request.setAttribute("name", name);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //登录失败
        sendJsonMessage(response, JsonData.buildError(500,"登录过期，重新登录"));
        return false;
    }

    /**
     * 登录失败，告诉前端
     */
    public static void sendJsonMessage(HttpServletResponse response, Object obj) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            //设置http响应类型
            response.setContentType("application/json; charset=utf-8");
            PrintWriter printWriter = response.getWriter();
            printWriter.println(objectMapper.writeValueAsString(obj));
            response.flushBuffer();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
