package com.itheima.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.itheima.entity.Result;
import com.itheima.util.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//定义拦截器拦截器
@Slf4j
@Component
public class LoginInterceptor implements HandlerInterceptor {

    //返回值为true 放行 false 拦截
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //获取请求路径  判断是否是login
        String url = request.getRequestURL().toString();
        log.info("请求的url为:" + url);
        if (url.contains("login")){
            log.info("git测试");
            log.info("登陆操作，放行");
            return true;
        }
        //不是登录操作
        //获取请求中的jwt令牌  jwt令牌在请求头的token中携带
        String jwt = request.getHeader("token");
        //判断jwt令牌是否存在
        //不存在
        if (!StringUtils.hasLength(jwt)){
            log.error("请求头token为空");
            //返回 NOT_LOGIN 响应
            Result error = Result.error("NOT_LOGIN");
            //手动转换Result对象为json对象 fastJSON依赖
            String notLogin = JSONObject.toJSONString(error);
            //手动响应
            response.getWriter().write(notLogin);
            return false;
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
            response.getWriter().write(notLogin);
        }
        //放行
        return true;
    }
}
