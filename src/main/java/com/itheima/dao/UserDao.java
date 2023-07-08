package com.itheima.dao;


import com.itheima.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * 用户表(User)表数据库访问层
 *
 * @author makejava
 * @since 2023-05-27 10:54:05
 */
@Mapper
public interface UserDao {

    //根据用户名密码查询用户
    @Select("select * from user where username = #{username} and password = #{password}")
    User login(User user);
}

