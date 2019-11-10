package cn.bysjm.util;

// 线程绑定工具类

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Component
public class ConnectionUtils {

    private static ThreadLocal<Connection> tl = new ThreadLocal<>();

    @Autowired
    private DataSource dataSource;

    // 从线程绑定conn并获得
    public Connection getTreadConnection() {
        Connection connection = tl.get();
        if (connection == null) {
            try {
                connection = dataSource.getConnection();
                tl.set(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return connection;
    }

    // 从当前线程解除绑定
    public void removeThreadConnection() {
        tl.remove();
    }
}
