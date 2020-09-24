package com.neilge.accountManage.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

/**
 * @author Neo
 *
 * @since 09/23/2020-11:40 PM
 */
@Component
public class TransactionManager {

    @Autowired
    private ConnectionUtil connectionUtil;

    public void beginTransaction() {
        try {
            connectionUtil.getThreadConnection().setAutoCommit(false);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void commit() {
        try {
            connectionUtil.getThreadConnection().commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void rollback() {
        try {
            connectionUtil.getThreadConnection().rollback();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void releaseConnection() {
        try {
            connectionUtil.getThreadConnection().close();
            connectionUtil.removeConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
