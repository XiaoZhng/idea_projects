package com.mvc.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.UsesSunMisc;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * @author Alonso
 */
//@RestController
@Controller
public class FileDownController {

    @RequestMapping("/testDown")
    public ResponseEntity<byte[]> testResponseEntity(HttpSession session) throws IOException {
        //获取ServletContext对象
        ServletContext servletContext = session.getServletContext();
        //获取服务器中文件的真实路径
        String realPath = servletContext.getRealPath("/static/img/1.jpg");
        System.out.println("realPath= " + realPath);
        //创建输入流
        InputStream is = new FileInputStream(realPath);
        //创建字节数组
        //is.available()：输入流所对应的文件所有的字节
        byte[] bytes = new byte[is.available()];
        //将流读到字节数组中
        is.read(bytes);
        //创建HttpHeaders对象设置响应头信息
        MultiValueMap<String, String> headers = new HttpHeaders();
        //HttpHeaders httpHeaders = new HttpHeaders();
        //设置要下载方式以及下载文件的名字
        headers.add("Content-Disposition", "attachment;filename=1.jpg");
        //设置响应状态码
        HttpStatus statusCode = HttpStatus.OK;
        //创建ResponseEntity对象
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<byte[]>(bytes, headers, statusCode);
        //关闭输入流
        is.close();
        return responseEntity;
    }

    @RequestMapping("/testUp")
    public String testDown(MultipartFile phone, HttpSession session) throws IOException {
        //获取上传文件的文件名
        String filename = phone.getOriginalFilename();
        ServletContext servletContext = session.getServletContext();
        String realPath = servletContext.getRealPath("phone");
        //截取后缀
        String suffixName = filename.substring(filename.lastIndexOf("."));
        //获取UUID
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        //把UUID和后缀进行拼接，得到文件名
        filename = uuid + suffixName;
        File file = new File(realPath);
        //判断realPath所对应的路径是否存在
        if (!file.exists()){
            file.mkdir();
        }
        //File.separator：分隔符
        //把路径进行拼接
        String finalPath = realPath + File.separator + filename;
        System.out.println(finalPath);
        phone.transferTo(new File(finalPath));
        return "success";
    }

}
