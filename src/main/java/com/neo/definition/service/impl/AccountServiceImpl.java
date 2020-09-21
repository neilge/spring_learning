package com.neo.definition.service.impl;

import com.neo.definition.dao.AccountDao;
import com.neo.definition.factory.BeanFactory;
import com.neo.definition.service.AccountService;

/**
 * @author Neo
 * @since 09/20/2020-6:15 PM
 */
public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao = (AccountDao) BeanFactory.getBean("accountDao");

    public void saveAccount() {
        accountDao.saveAccount();
    }
}
