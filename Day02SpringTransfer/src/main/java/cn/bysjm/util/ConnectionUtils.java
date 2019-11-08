package cn.bysjm.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Component
public class ConnectionUtils {

    private ThreadLocal<Connection> tl = new ThreadLocal<>();

    @Autowired
    private DataSource dataSource;

    public Connection getThreadConnection(){
        Connection connection = tl.get();
        if (connection == null){
            try {
                connection = dataSource.getConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            tl.set(connection);
        }
        return connection;
    }

    public void removeThreadConnection(){
        tl.remove();
    }

}
