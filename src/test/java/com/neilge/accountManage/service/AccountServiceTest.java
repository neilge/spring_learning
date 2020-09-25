package com.neilge.accountManage.service;

import com.neilge.accountManage.config.SpringConfiguration;
import com.neilge.accountManage.domain.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author Neo
 * @since 09/21/2020-11:05 PM
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class AccountServiceTest {

    @Autowired
//    @Qualifier("ProxyAccountService")
    AccountService service;

    @Test
    public void testFindAll() {
        List<Account> accounts = service.findAllAccount();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    @Test
    public void testFindOne() {
        Account account = service.findAccountById(1);
        System.out.println(account);
    }

    @Test
    public void testSave() {
        Account account = new Account();
        account.setName("fff");
        account.setMoney(1235f);

        service.saveAccount(account);
    }

    @Test
    public void testUpdate() {
        Account account = service.findAccountById(4);
        account.setMoney(1000f);
        service.updateAccount(account);
    }

    @Test
    public void testDelete() {
        service.deleteAccount(2);
    }

    @Test
    public void testTransfer() {
        service.transfer("aaa", "ccc", 100f);
    }
}