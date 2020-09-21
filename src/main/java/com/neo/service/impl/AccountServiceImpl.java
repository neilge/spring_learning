package com.neo.service.impl;

import com.neo.dao.AccountDao;
import com.neo.dao.impl.AccountDaoImpl;
import com.neo.service.AccountService;

/**
 * @author Neo
 * @since 09/20/2020-6:15 PM
 */
public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao = new AccountDaoImpl();

    public void saveAccount() {
        accountDao.saveAccount();
    }
}
