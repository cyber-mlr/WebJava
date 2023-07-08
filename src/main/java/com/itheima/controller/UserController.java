package com.itheima.controller;


import com.itheima.entity.Result;
import com.itheima.entity.User;
import com.itheima.service.UserService;
import com.itheima.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;


/**
 * 用户表(User)表控制层
 *
 * @author makejava
 * @since 2023-05-27 10:54:05
 */
@RestController
public class UserController {

    //注入User service 对象

    @Autowired
    private UserService userService;

    //用户登录
    @PostMapping("/login")
    public Result login(@RequestBody User user){

        //调用 service 层登录方法  login  返回User对象  空 不存在 登录失败 存在 登录成功  下发jwt令牌
        User userinfo = userService.login(user);

        if (userinfo != null){
            //生成jwt令牌
            HashMap<String, Object> claims = new HashMap<>();
            claims.put("id",userinfo.getId());
            String jwt = JwtUtils.generateJwt(claims);

            return Result.success(jwt);
        }else {
            return Result.error("用户名或密码错误");
        }
    }

}

