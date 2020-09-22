package com.neilge.accountManage.service;

import com.neilge.accountManage.domain.Account;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author Neo
 * @since 09/21/2020-11:05 PM
 */
public class AccountServiceTest  {

    ApplicationContext context;
    AccountService service;

    @Before
    public void setUp() {
        context = new ClassPathXmlApplicationContext("accountbean.xml");
        service = context.getBean("accountService", AccountService.class);
    }

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
        account.setName("eee");
        account.setMoney(1234f);

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
}