package com.mbplus.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * @author Alonso
 */
@Getter //因为是常量，所以不需要设置set
public enum SexEnum {
    MALE(1, "男"),
    FEMALE(2, "女");

    @EnumValue //将注解所标识的属性的值存储到数据库中
    private Integer sex;
    private String sexName;

    SexEnum(Integer sex, String sexName) {
        this.sex = sex;
        this.sexName = sexName;
    }
}
