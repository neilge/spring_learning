package com.neilge.accountManage.factory;

import com.neilge.accountManage.service.AccountService;
import com.neilge.accountManage.util.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Neo
 * @since 09/24/2020-3:40 PM
 */
@Component
public class BeanFactory {

    @Autowired
    private AccountService accountService;

    @Autowired
    private TransactionManager txManager;

    @Bean("ProxyAccountService")
    public AccountService getAccountService() {
        return (AccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader(), accountService.getClass().getInterfaces(), new InvocationHandler() {
            Object result = null;

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) {
                try {
                    txManager.beginTransaction();
                    System.out.println("Transaction start!!!");
                    result = method.invoke(accountService, args);
                    txManager.commit();
                    return result;
                } catch (Exception e) {
                    System.out.println("Transaction fail!!!");
                    txManager.rollback();
                    throw new RuntimeException(e);
                } finally {
                    System.out.println("Transaction complete!!!");
                    txManager.releaseConnection();
                }
            }
        });
    }
}
