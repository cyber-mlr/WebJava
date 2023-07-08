package com.itheima.controller;


import com.itheima.entity.PageBean;
import com.itheima.entity.Product;
import com.itheima.entity.Result;
import com.itheima.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 商品表(Product)表控制层
 *
 * @author makejava
 * @since 2023-05-27 10:51:14
 */
@Slf4j
@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    //查询商品  get  分页条件查询
    @GetMapping
    public Result selectProducts(@RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "10") Integer pageSize,String name,Integer priceBegin, Integer priceEnd){
        //调用ProductService层的查询方法 返回商品集合
        PageBean pageBean = productService.selectProducts(page,pageSize,name,priceBegin,priceEnd);
        log.info("查询商品,参数 {},{},{},{},{}",page,pageSize,name,priceBegin,priceEnd);
        return Result.success(pageBean);
    }

    //根据 id 查询  /products/{id}
    @GetMapping("/{id}")
    public Result selectProductById(@PathVariable Integer id){
        //调用ProductService层的查询方法
        Product product = productService.selectProductById(id);
        return Result.success(product);
    }

    //新增商品 post
    @PostMapping
    public Result insertProduct(@RequestBody Product product){
        //调用ProductService层 新增方法
        productService.insertProduct(product);
        return Result.success();
    }

    //修改商品 put
    @PutMapping
    public Result updateProduct(@RequestBody Product product){
        productService.updateProduct(product);
        return Result.success();
    }

    //删除商品 delete  /products/{ids}
    @DeleteMapping("/{ids}")
    public Result deleteProduct(@PathVariable List<Integer> ids){
        productService.deleteProduct(ids);
        return Result.success();
    }

}

