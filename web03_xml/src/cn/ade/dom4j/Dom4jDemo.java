package cn.ade.dom4j;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.io.File;
import java.util.List;

/**
 * 需求：解析xml文件
 *
 * @author ade
 * @version 1.0， 2017-10-08 20:11:04
 */
public class Dom4jDemo {

    @Test
    public void method01() throws DocumentException {
        // 加载xml文件
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(new File("src/c3p0.xml"));

        // 获取根元素
        Element rootElement = document.getRootElement();
        // System.out.println(rootElement);
        // org.dom4j.tree.DefaultElement@29fb6448 [Element: <c3p0-config attributes: [org.dom4j.tree.DefaultAttribute@3774c880 [Attribute: name version value "1.0"]]/>]

        // 获取根元素的属性值
        String version = rootElement.attributeValue("version");
        // System.out.println(version); 	// 1.0

        // 获取所有的子元素
        List<Element> list = rootElement.elements();
        for (Element element : list) {
            System.out.println(element.getName());    // default-config
            System.out.println("---------------------");

            List<Element> list2 = element.elements();
            for (Element element2 : list2) {
                System.out.print(element2.getName() + "---");
                System.out.println(element2.getText());

                List<Attribute> list3 = element2.attributes();
                for (Attribute attribute : list3) {
                    System.out.println(attribute.getName() + "-" + attribute.getValue());
                }
            }

			/*
            default-config
			---------------------
			property---com.mysql.jdbc.Driver
			name-driverClass
			property---jdbc:mysql://localhost:3306/db1
			name-jdbcUrl
			property---root
			name-user
			property---1234
			name-password
			*/
        }

    }

}
