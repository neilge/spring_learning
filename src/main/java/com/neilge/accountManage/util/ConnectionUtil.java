package com.neilge.accountManage.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Neo
 * @since 09/23/2020-11:35 PM
 */
@Component
public class ConnectionUtil {
    private ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

    @Autowired
    private DataSource dataSource;

    public Connection getThreadConnection() {
        Connection connection = threadLocal.get();
        if (connection == null) {
            try {
                connection = dataSource.getConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            threadLocal.set(connection);
        }
        return connection;
    }

    public void removeConnection() {
        threadLocal.remove();
    }
}
