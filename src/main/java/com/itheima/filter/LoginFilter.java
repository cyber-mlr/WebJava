package com.itheima.filter;

import com.alibaba.fastjson.JSONObject;
import com.itheima.entity.Result;
import com.itheima.util.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//配置Filter
//@WebFilter(urlPatterns = "/*")
@Slf4j
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        //获取请求路径  判断是否是login
        String url = httpServletRequest.getRequestURL().toString();
        log.info("请求的url为:" + url);
        if (url.contains("login")){
            log.info("登陆操作，放行");
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }
        //不是登录操作
        //获取请求中的jwt令牌  jwt令牌在请求头的token中携带
        String jwt = httpServletRequest.getHeader("token");
        //判断jwt令牌是否存在
        //不存在
        if (!StringUtils.hasLength(jwt)){
            log.error("请求头token为空");
            //返回 NOT_LOGIN 响应
            Result error = Result.error("NOT_LOGIN");
            //手动转换Result对象为json对象 fastJSON依赖
            String notLogin = JSONObject.toJSONString(error);
            //手动响应
            httpServletResponse.getWriter().write(notLogin);
            return;
        }
        //存在 校验jwt令牌 不报错即成功
        try {
            JwtUtils.parseJWT(jwt);
            log.info("解析成功");
        } catch (Exception e) {
            //解析失败  返回错误信息
            Result error = Result.error("NOT_LOGIN");
            //手动转换Result对象为json对象 fastJSON依赖
            String notLogin = JSONObject.toJSONString(error);
            //手动响应
            httpServletResponse.getWriter().write(notLogin);
        }
        //放行
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
