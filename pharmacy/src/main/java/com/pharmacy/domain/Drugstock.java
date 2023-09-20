package com.pharmacy.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 药品库存表
 * @TableName drugstock
 */
@TableName(value ="drugstock")
@Data
public class Drugstock implements Serializable {
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 药品id
     */
    @TableField("drugs_id")
    private Integer drugsId;

    /**
     * 库存
     */
    private Integer stock;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}