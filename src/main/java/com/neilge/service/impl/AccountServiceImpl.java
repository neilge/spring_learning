package com.neilge.service.impl;

import com.neilge.service.AccountService;
import com.neo.definition.dao.AccountDao;
import com.neo.definition.factory.BeanFactory;

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
