package com.itheima.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 商品表(Product)实体类
 *
 * @author makejava
 * @since 2023-05-27 10:51:14
 */
public class Product implements Serializable {
    private static final long serialVersionUID = 760181936834547935L;
    /**
     * ID
     */
    private Integer id;
    /**
     * 商品名称
     */
    private String name;
    /**
     * 价格
     */
    private Double price;
    /**
     * 图片
     */
    private String image;
    /**
     * 库存量
     */
    private Integer stock;
    /**
     * 描述信息
     */
    private String description;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updateTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

}

