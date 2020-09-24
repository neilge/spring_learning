package com.neilge.accountManage.service.impl;

import com.neilge.accountManage.dao.AccountDao;
import com.neilge.accountManage.domain.Account;
import com.neilge.accountManage.service.AccountService;
import com.neilge.accountManage.util.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Neo
 * @since 09/21/2020-10:39 PM
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Autowired
    private TransactionManager txManager;

    @Override
    public List<Account> findAllAccount() {
        try {
            txManager.beginTransaction();
            List<Account> accounts = accountDao.findAllAccount();
            txManager.commit();
            return accounts;
        } catch (Exception e) {
            txManager.rollback();
            throw new RuntimeException(e);
        } finally {
            txManager.releaseConnection();
        }
    }

    @Override
    public Account findAccountById(Integer accountId) {
        try {
            txManager.beginTransaction();
            Account account = accountDao.findAccountById(accountId);
            txManager.commit();
            return account;
        } catch (Exception e) {
            txManager.rollback();
            throw new RuntimeException(e);
        } finally {
            txManager.releaseConnection();
        }
    }

    @Override
    public void saveAccount(Account account) {
        try {
            txManager.beginTransaction();
            accountDao.saveAccount(account);
            txManager.commit();
        } catch (Exception e) {
            txManager.rollback();
            throw new RuntimeException(e);
        } finally {
            txManager.releaseConnection();
        }
    }

    @Override
    public void updateAccount(Account account) {
        try {
            txManager.beginTransaction();
            accountDao.updateAccount(account);
            txManager.commit();
        } catch (Exception e) {
            txManager.rollback();
            throw new RuntimeException(e);
        } finally {
            txManager.releaseConnection();
        }
    }

    @Override
    public void deleteAccount(Integer accountId) {
        try {
            txManager.beginTransaction();
            accountDao.deleteAccount(accountId);
            txManager.commit();
        } catch (Exception e) {
            txManager.rollback();
            throw new RuntimeException(e);
        } finally {
            txManager.releaseConnection();
        }
    }

    @Override
    public void transfer(String sourceName, String targetName, Float money) {

        try {
            txManager.beginTransaction();
            Account source = accountDao.findAccountByName(sourceName);
            Account target = accountDao.findAccountByName(targetName);
            source.setMoney(source.getMoney() - money);
            target.setMoney(target.getMoney() + money);
            accountDao.updateAccount(source);
//            int i = 1/0;
            accountDao.updateAccount(target);
            txManager.commit();
        } catch (Exception e) {
            txManager.rollback();
            throw new RuntimeException(e);
        } finally {
            txManager.releaseConnection();
        }
    }
}
