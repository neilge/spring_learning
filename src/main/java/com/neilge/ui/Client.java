package com.neilge.ui;

import com.neo.definition.dao.AccountDao;
import com.neo.definition.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Neo
 * @since 09/20/2020-6:31 PM
 */
public class Client {

    /**
     * ApplicationContext的三个常用实现类:
     * 1. ClassPathXmlApplicationContext: 加载类路径下的配置文件
     * 2. FileSystemXmlApplicationContext:加载磁盘任意路径下的配置文件(必须有访问权限)
     * 3. AnnotationConfigApplicationContext: 读取注解
     *
     * 核心容器的两个接口引发出的问题:
     * 1. ApplicationContext: 在构建核心容器时, 创建对象采取的策略是采用立即加载的方式.也就是说, 只要一读取完配置文件马上就创建配置文件中的对象.
     *  适合单例对象
     * 2. BeanFactory: 创建对象是采用延迟加载的方式.
     *  适合非单例对象
     *
     *
     * @param args
     */

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        AccountService service = (AccountService) context.getBean("accountService");
        AccountDao dao = context.getBean("accountDao", AccountDao.class);
        service.saveAccount();
    }
}
