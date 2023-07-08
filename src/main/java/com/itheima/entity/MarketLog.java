package com.itheima.entity;

import java.time.LocalDateTime;
import java.util.Date;
import java.io.Serializable;

/**
 * 日志记录表(MarketLog)实体类
 *
 * @author makejava
 * @since 2023-05-27 19:47:32
 */
public class MarketLog implements Serializable {
    private static final long serialVersionUID = -55773171684039482L;
    /**
     * ID
     */
    private Integer id;
    /**
     * 用户ID
     */
    private Integer userId;
    /**
     * 方法名
     */
    private String methodName;
    /**
     * 请求参数
     */
    private String param;
    /**
     * 返回值
     */
    private String result;
    /**
     * 操作时间
     */
    private LocalDateTime time;

    public MarketLog(Integer userId, String methodName, String param, String result, LocalDateTime time) {
        this.userId = userId;
        this.methodName = methodName;
        this.param = param;
        this.result = result;
        this.time = time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}

