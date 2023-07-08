package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.dao.ProductDao;
import com.itheima.entity.PageBean;
import com.itheima.entity.Product;
import com.itheima.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


/**
 * 商品表(Product)表服务实现类
 *
 * @author makejava
 * @since 2023-05-27 10:51:15
 */
@Service
public class ProductServiceImpl implements ProductService {
    //注入ProductDao 对象
    @Autowired
    private ProductDao productDao;

    @Override
    public PageBean selectProducts(Integer page, Integer pageSize, String name, Integer priceBegin, Integer priceEnd) {
        //设置分页参数
        PageHelper.startPage(page,pageSize);

        //调用Dao 层方法
        List<Product> list = productDao.selectProducts(name,priceBegin,priceEnd);
        //获取Page对象
        Page p = (Page) list;

        //封装PageBean对象
        return new PageBean(p.getTotal(),p.getResult());
    }

    @Override
    public Product selectProductById(Integer id) {
        //调用Dao 层方法
        return productDao.selectProductById(id);
    }

    @Override
    public void insertProduct(Product product) {
        //调用Dao 层方法
        product.setUpdateTime(new Date());
        product.setCreateTime(new Date());
        productDao.insertProduct(product);
    }

    @Override
    public void updateProduct(Product product) {
        product.setUpdateTime(new Date());
        productDao.updateProduct(product);
    }

    @Override
    public void deleteProduct(List<Integer> ids) {
        productDao.deleteProduct(ids);
    }
}
