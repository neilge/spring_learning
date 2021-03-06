package com.neilge.accountManage.dao.impl;

import com.neilge.accountManage.dao.AccountDao;
import com.neilge.accountManage.domain.Account;
import com.neilge.accountManage.util.ConnectionUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Neo
 * @since 09/21/2020-10:43 PM
 */
@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private QueryRunner runner;

    @Autowired
    private ConnectionUtil connectionUtil;

    @Override
    public List<Account> findAllAccount() {
        try {
            return runner.query(connectionUtil.getThreadConnection(), "select * from account", new BeanListHandler<Account>(Account.class));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Account findAccountById(Integer accountId) {
        try {
            return runner.query(connectionUtil.getThreadConnection(), "select * from account where id = ?", new BeanHandler<Account>(Account.class), accountId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveAccount(Account account) {
        try {
            runner.update(connectionUtil.getThreadConnection(), "insert into account(name, money) values(?, ?)", account.getName(), account.getMoney());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateAccount(Account account) {
        try {
            runner.update(connectionUtil.getThreadConnection(), "update account set name=?, money=? where id =?", account.getName(), account.getMoney(), account.getId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteAccount(Integer accountId) {
        try {
            runner.update(connectionUtil.getThreadConnection(), "delete from account where id=?", accountId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Account findAccountByName(String accountName) {
        try {
            List<Account> accounts = runner.query(connectionUtil.getThreadConnection(), "select * from account where name = ?", new BeanListHandler<Account>(Account.class), accountName);
            if (accounts == null || accounts.size() == 0) {
                return null;
            }
            if (accounts.size() > 1) {
                throw new RuntimeException("More than one result was found");
            }
            return accounts.get(0);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
