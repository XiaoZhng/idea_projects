package com.zledu.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Alonso
 */
public class WebUtils {

    public static String getPath(HttpServletRequest request){
        //获取请求路径（servlet的路径）
        String uri = request.getRequestURI();
        //获取请求路径中所拼接的请求参数
        String queryString = request.getQueryString();
        //判断请求参数中是否有 &pageNo
        if (queryString.contains("&pageNo")){
            //将请求参数中的 &pageNo截掉
            queryString= queryString.substring(0, queryString.indexOf("&pageNo"));
        }
        //将动态获取的请求路径返回
        return uri + "?" + queryString;
    }
}
