package com.itheima.service.impl;


import com.itheima.dao.UserDao;
import com.itheima.entity.User;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 用户表(User)表服务实现类
 *
 * @author makejava
 * @since 2023-05-27 10:54:06
 */
@Service
public class UserServiceImpl implements UserService {

    //注入UserDao 对象
    @Autowired
    private UserDao userDao;


    //用户登录
    @Override
    public User login(User user) {
        //调用dao层登录方法
        User userinfo = userDao.login(user);

        return user;
    }
}
