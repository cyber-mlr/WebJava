package com.itheima.dao;


import com.itheima.entity.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 商品表(Product)表数据库访问层
 *
 * @author makejava
 * @since 2023-05-27 10:51:14
 */
@Mapper
public interface ProductDao {

    //查询产品
//    @Select("select * from product where name like concat('%',#{name},'%') and price between #{priceBegin} and #{priceEnd}")
    List<Product> selectProducts(String name, Integer priceBegin, Integer priceEnd);

    //通过id查询商品
    @Select("select * from product where id = #{id}")
    Product selectProductById(Integer id);

    //新增商品
    @Insert("insert into product (name,price,image,stock,description,create_time,update_time) values (#{name}, #{price}, #{image}, #{stock}, #{description}, #{createTime}, #{updateTime})")
    void insertProduct(Product product);

    //修改商品
    @Update("update product set name = #{name},price = #{price},image = #{image},stock = #{stock},description = #{description},update_time = #{updateTime} where id = #{id}")
    void updateProduct(Product product);

    //批量删除
    //@Delete("delete from product where id in ids")
    void deleteProduct(List<Integer> ids);
}

