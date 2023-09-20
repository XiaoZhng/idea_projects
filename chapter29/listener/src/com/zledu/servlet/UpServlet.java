package com.zledu.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * @author Alonso
 * 文件上传功能
 */
public class UpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码格式
        request.setCharacterEncoding("UTF-8");
        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);

        try {
            List<FileItem> fileItems = servletFileUpload.parseRequest(request);
            for (FileItem fileItem : fileItems) {
                //fileItem.isFormField()返回true时，代表所传输的数据不是文件，是一个普通的表单元素
                //fileItem.isFormField()返回false时，代表所传输的数据是文件
                if (!fileItem.isFormField()){
                    //获取文件名
                    String name = fileItem.getName();
                    //获取编译路径
                    String realPath = request.getServletContext().getRealPath("phone");
                    //获取一个 String类型的 UUID
                    String uuid = UUID.randomUUID().toString();
                    //将 uuid中的 - 替换成 ""
                    uuid = uuid.replaceAll("-", "");
                    //System.out.println("name= " + name);//文件名
                    //将uuid 与 文件名的后缀拼接，得到一个新的文件名，可以防止文件重复，避免同名内容覆盖
                    //获取文件后缀名
                    String hzName = name.substring(name.lastIndexOf("."));
                    //与uuid拼接
                    String FileName = uuid + hzName;
                    //System.out.println("FileName= " + FileName);
                    //判断 realPath是否存在，不存在则创建
                    File file = new File(realPath);
                    if (!file.exists()){
                        file.mkdir();
                    }
                    //编译路径 + 文件名
                    String filePath = realPath + "/" + FileName;
                    //写入文件夹中
                    fileItem.write(new File(filePath));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
