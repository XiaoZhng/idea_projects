package com.mbplus.pojo;

import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

/**
 * @author Alonso
 */
@Data
public class Product {
    private Long id;
    private String name;
    private Integer price;
    @Version //表示乐观锁版本号字段
    private Integer version;
}
