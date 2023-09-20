package com.zledu.xml;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author Alonso
 */
public class CreateXML {
    public static void main(String[] args) throws IOException {

        //创建 Document文档对象
        Document document = DocumentHelper.createDocument();
        //创建一个标签
        Element userElement = document.addElement("user");
        //设置根标签
        document.setRootElement(userElement);

        Element infoElement = userElement.addElement("info");

        //在根标签中，创建 username、password、sex
        Element username = infoElement.addElement("username");
        Element password = infoElement.addElement("password");
        Element sex = infoElement.addElement("sex");
        //为标签赋值
        username.addText("张三");
        password.addText("123456");
        sex.addText("男");

        OutputFormat outputFormat = new OutputFormat("  ", true);
        OutputStream outputStream = new FileOutputStream("xml/src/user.xml");
        XMLWriter xmlWriter = new XMLWriter(outputStream, outputFormat);
        xmlWriter.write(document);
    }
}
