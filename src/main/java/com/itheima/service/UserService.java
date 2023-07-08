package com.itheima.service;


import com.itheima.entity.User;

/**
 * 用户表(User)表服务接口
 *
 * @author makejava
 * @since 2023-05-27 10:54:06
 */
public interface UserService {


    //登录
    User login(User user);
}
