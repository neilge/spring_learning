package com.neo.ui;

import com.neo.service.AccountService;
import com.neo.service.impl.AccountServiceImpl;

/**
 * @author Neo
 * @since 09/20/2020-6:31 PM
 */
public class Client {
    public static void main(String[] args) {
        AccountService accountService = new AccountServiceImpl();
        accountService.saveAccount();
    }
}
