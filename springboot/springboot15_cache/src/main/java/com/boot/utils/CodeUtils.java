package com.boot.utils;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * @author Alonso
 */
@Component
public class CodeUtils {

    private String[] patch = {"000000", "00000", "0000", "000", "00", "0", ""};

    //根据电话号码生成验证码的算法
    public String generator(String tel){
        int hashCode = tel.hashCode();
        int encryption = 20220921;
        long result = hashCode ^ encryption;
        long nowTime = System.currentTimeMillis();
        result = result ^ nowTime;
        long code = result & 100000;
        code = code < 0 ? -code : code;

        //code = 1223;
        String codeStr = code + "";
        int len = codeStr.length();
        return  patch[len]+ codeStr;
    }

    @Cacheable(value = "smsCode", key = "#tel")
    public String jyCode(String tel){
        return null;
    }

//    public static void main(String[] args) {
//        System.out.println(new CodeUtils().generator("178675362"));
//    }
}
