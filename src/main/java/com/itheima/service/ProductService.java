package com.itheima.service;


import com.itheima.entity.PageBean;
import com.itheima.entity.Product;

import java.math.BigDecimal;
import java.util.List;

/**
 * 商品表(Product)表服务接口
 *
 * @author makejava
 * @since 2023-05-27 10:51:15
 */
public interface ProductService {

    PageBean selectProducts(Integer page, Integer pageSize, String name, Integer priceBegin, Integer priceEnd);

    Product selectProductById(Integer id);

    void insertProduct(Product product);

    void updateProduct(Product product);

    void deleteProduct(List<Integer> ids);
}
