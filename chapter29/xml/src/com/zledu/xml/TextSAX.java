package com.zledu.xml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * @author Alonso
 */
public class TextSAX {
    public static void main(String[] args) throws DocumentException {

        SAXReader saxReader = new SAXReader();
        Document read = saxReader.read("xml/src/user.xml");
        //获取根元素
        Element rootElement = read.getRootElement();
        //获取根标签下的info标签
        Element info = rootElement.element("info");
        //根据标签名获取根元素的内容
        Element username = info.element("username");
        Element password = info.element("password");
        Element sex = info.element("sex");
        //获取标签的文本内容
        System.out.println(username.getText());
        System.out.println(password.getText());
        System.out.println(sex.getText());

    }
}
