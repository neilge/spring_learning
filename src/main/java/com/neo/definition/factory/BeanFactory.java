package com.neo.definition.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * The factory that create bean object.
 * <p>
 * Bean: 在计算机英语中, 有可重用组件的含义.
 * JavaBean: 用Java编写的可重用组件. JavaBean > 实体类
 * <p>
 * <p>
 * 1. 需要一个配置文件来配置service和dao的配置内容: key=value
 * 2. 通过读取配置文件中的内容, 反射创建对象
 * <p>
 * 配置文件可以是xml也可以是properties
 *
 * @author Neo
 * @since 09/20/2020-6:39 PM
 */
public class BeanFactory {
    private static Properties props;

    static {
        props = new Properties();
        InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
        try {
            props.load(in);
        } catch (IOException e) {
            throw new ExceptionInInitializerError("Fail to initialize properties");
        }
    }

    public static Object getBean(String beanName) {
        Object bean = null;
        String beanPath = props.getProperty(beanName);
        try {
            bean = Class.forName(beanPath).getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }
}
