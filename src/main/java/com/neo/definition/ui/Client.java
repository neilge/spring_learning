package com.neo.definition.ui;

import com.neo.definition.factory.BeanFactory;
import com.neo.definition.service.AccountService;

/**
 * @author Neo
 * @since 09/20/2020-6:31 PM
 */
public class Client {
    public static void main(String[] args) {
        AccountService accountService = (AccountService) BeanFactory.getBean("accountService");
        accountService.saveAccount();
    }
}
