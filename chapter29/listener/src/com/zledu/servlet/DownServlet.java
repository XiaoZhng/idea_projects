package com.zledu.servlet;

import sun.misc.BASE64Encoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * @author Alonso
 */
public class DownServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码格式
        request.setCharacterEncoding("UTF-8");
        //获取请求对象
        String musicName = request.getParameter("musicName");
        //获取文件在编译目录下的路径
        String realPath = request.getServletContext().getRealPath("music" + File.separator + musicName);
        //获取下载下载的文件类型
        String mimeType = request.getServletContext().getMimeType(realPath);
        //设置响应内容格式
        response.setContentType(mimeType);
        //处理中文乱码
        String header = request.getHeader("User-Agent");//通过请求头User-Agent获取浏览器信息
        //判断客户端是否为火狐
        if (header.contains("Firefox")){
            //若为火狐使用BASE64编码
            musicName = "=?utf-8?B?"+new BASE64Encoder()
                    .encode(musicName.getBytes("utf-8"))+"?=";
        }else{
            //否则使用UTF-8
            musicName = URLEncoder.encode(musicName,"utf-8");
        }
        //设置下载方式
        response.setHeader("Content-Disposition", "attachment; filename="+ musicName);
        //文件复制
        FileInputStream fileInputStream = new FileInputStream(realPath);
        ServletOutputStream outputStream = response.getOutputStream();
        byte[] b = new byte[1024];
        int length = 0;
        while ((length = fileInputStream.read(b)) != -1){
            outputStream.write(b, 0, length);
        }
        //关闭资源
        fileInputStream.close();
    }
}
