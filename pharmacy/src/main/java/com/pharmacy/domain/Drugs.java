package com.pharmacy.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName drugs
 */
@TableName(value ="drugs")
@Data
public class Drugs implements Serializable {
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 药品名称
     */
    private String drugsName;

    /**
     * 生产厂家
     */
    private String factory;

    /**
     * 规格
     */
    private String specifications;

    /**
     * 药品单位
     */
    private String company;

    /**
     * 药品单价
     */
    private String price;

    private Integer stock;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}