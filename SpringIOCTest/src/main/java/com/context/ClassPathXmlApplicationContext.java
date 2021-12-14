package com.context;

import com.pojo.Bean;
import com.pojo.Property;
import com.config.ConfigManager;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class ClassPathXmlApplicationContext implements BeanFactory {

    private final Map<String, Bean> map;

    private final Map<String, Object> context = new HashMap<>(16);

    public ClassPathXmlApplicationContext(String path) {
        map = ConfigManager.getConfig(path);
        for (Map.Entry<String, Bean> e: map.entrySet()) {
            String beanName = e.getKey();
            Bean bean = e.getValue();
            Object existBean = context.get(beanName);
            if (existBean != null && "singleton".equals(bean.getScope())) {
                Object object = createBean(bean);
                context.put(beanName, object);
            }
        }
    }

    private Object createBean(Bean bean) {
        Class<?> c = null;
        try {
            c = Class.forName(bean.getClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Object o = null;
        try {
            assert c != null;
            o = c.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        for (Property p: bean.getPropertyList()) {
            String name = p.getName();
            String value = p.getValue();
            if (value != null) {
                Map<String, String[]> paramMap = new HashMap<>(2);
                paramMap.put(name, new String[]{value});
                try {
                    BeanUtils.populate(o, paramMap);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
            String ref = p.getRef();
            if (ref != null) {
                Object existBean = context.get(ref);
                if (existBean == null) {
                    existBean = createBean(map.get(ref));
                    if ("singleton".equals(map.get(ref).getScope())) {
                        context.put(ref, existBean);
                    }
                }
                try {
                    BeanUtils.setProperty(o, name, existBean);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        return o;
    }


    @Override
    public Object getBean(String name) {
        Object o = context.get(name);
        if (o == null) {
            o = createBean(map.get(name));
        }
        return o;
    }

}
