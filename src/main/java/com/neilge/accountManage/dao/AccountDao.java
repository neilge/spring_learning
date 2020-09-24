package com.neilge.accountManage.dao;

import com.neilge.accountManage.domain.Account;

import java.util.List;

/**
 * @author Neo
 * @since 09/21/2020-10:40 PM
 */
public interface AccountDao {

    List<Account> findAllAccount();

    Account findAccountById(Integer accountId);

    void saveAccount(Account account);

    void updateAccount(Account account);

    void deleteAccount(Integer accountId);

    Account findAccountByName(String accountName);
}
