package com.boot.controller.utils;

import lombok.Data;

/**
 * @author Alonso
 */
@Data
public class R {
    /**
     * 该类是设计统一返回值结果类型便于前端开发读取数据
     * 返回值结果类型可以根据需求自行设定，没有固定格式
     * 返回值结果模型类用于后端于前端进行数据格式统一，也称为前后端数据协议
     */
    private Boolean flag;
    private Object data;
    private String message;

    public R() {
    }

    public R(Boolean flag) {
        this.flag = flag;
    }

    public R(Boolean flag, Object data) {
        this.flag = flag;
        this.data = data;
    }

    //从后台传输数据给页面
    public R(Boolean flag, String message){
        this.flag = flag;
        this.message = message;
    }

    //此构造器用于异常处理器，发生异常时，状态为false，返回错误提示
    public R(String message){
        this.flag = false;
        this.message = message;
    }
}