package com.config;

import com.pojo.Bean;
import com.pojo.Property;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConfigManager {

    private static final Map<String, Bean> MAP = new HashMap<>(16);


    @SuppressWarnings("unchecked")
    public static Map<String, Bean> getConfig(String path) {
        SAXReader saxReader = new SAXReader();
        File file = new File(path);
        Document document;
        try {
            InputStream inputStream = new FileInputStream(file);
            document = saxReader.read(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
            return new HashMap<>(1);
        }
        String xPath = "//bean";
        List<Element> elementList = document.selectNodes(xPath);
        for (Element element: elementList) {
            Bean bean = new Bean();
            String name = element.attributeValue("name");
            bean.setName(name);
            String className = element.attributeValue("class");
            bean.setClassName(className);
            String scope = element.attributeValue("scope");
            if (scope != null) {
                bean.setScope(scope);
            }

            List<Element> childElementList = element.elements("property");
            for (Element childElement: childElementList) {
                Property property = new Property();
                String childName = childElement.attributeValue("name");
                property.setName(childName);
                String childValue = childElement.attributeValue("value");
                property.setValue(childValue);
                String childRef = childElement.attributeValue("ref");
                property.setRef(childRef);
                bean.getPropertyList().add(property);
            }
            MAP.put(name, bean);
        }
        return MAP;
    }

}
