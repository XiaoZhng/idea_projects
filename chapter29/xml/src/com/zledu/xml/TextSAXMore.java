package com.zledu.xml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.List;

/**
 * @author Alonso
 */
public class TextSAXMore {
    public static void main(String[] args) throws DocumentException {

        SAXReader saxReader = new SAXReader();
        Document read = saxReader.read("xml/src/user.xml");
        //获取根元素
        Element rootElement = read.getRootElement();
        //获取根标签下的所有info标签
        List elements = rootElement.elements();
        for (Object o : elements) {
            Element element = (Element) o;//强转，把o转成 Element
            Element username = element.element("username");
            Element password = element.element("password");
            Element sex = element.element("sex");
            //获取标签的文本内容
            System.out.println(username.getText());
            System.out.println(password.getText());
            System.out.println(sex.getText());
        }
    }
}
