package com.neilge.accountManage.service.impl;

import com.neilge.accountManage.dao.AccountDao;
import com.neilge.accountManage.domain.Account;
import com.neilge.accountManage.service.AccountService;

import java.util.List;

/**
 * @author Neo
 * @since 09/21/2020-10:39 PM
 */
public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;

    @Override
    public List<Account> findAllAccount() {
        return accountDao.findAllAccount();
    }

    @Override
    public Account findAccountById(Integer accountId) {
        return accountDao.findAccountById(accountId);
    }

    @Override
    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }

    @Override
    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    @Override
    public void deleteAccount(Integer accountId) {
        accountDao.deleteAccount(accountId);
    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }
}