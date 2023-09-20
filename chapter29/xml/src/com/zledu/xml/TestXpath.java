package com.zledu.xml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.util.List;

/**
 * @author Alonso
 * 通过 Xpath解析 xml
 */
public class TestXpath {

    public static void main(String[] args) throws DocumentException {

        SAXReader saxReader = new SAXReader();
        Document read = saxReader.read("xml/src/user.xml");

        //获取单个内容
        //Node node = read.selectSingleNode("/user/info/username");
        //System.out.println(node.getText());

        //获取多个内容
        List list = read.selectNodes("/user/info/username");
        for (Object o : list) {
            Node node = (Node) o;
            System.out.println(node.getText());
        }

    }
}
