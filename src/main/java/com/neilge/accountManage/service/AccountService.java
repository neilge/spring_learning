package com.neilge.accountManage.service;

import com.neilge.accountManage.domain.Account;

import java.util.List;

/**
 * @author Neo
 * @since 09/21/2020-9:45 PM
 */
public interface AccountService {

    List<Account> findAllAccount();

    Account findAccountById(Integer accountId);

    void saveAccount(Account account);

    void updateAccount(Account account);

    void deleteAccount(Integer accountId);
}
