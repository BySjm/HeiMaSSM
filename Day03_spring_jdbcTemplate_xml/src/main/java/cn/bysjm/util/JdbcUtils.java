package cn.bysjm.util;

import com.alibaba.druid.pool.DruidDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class JdbcUtils {

    private static DruidDataSource dc =  new DruidDataSource();

    static {
        ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
        String driverClass = bundle.getString("jdbc.driver");
        String jdbcUrl = bundle.getString("jdbc.url");
        String username = bundle.getString("jdbc.username");
        String password = bundle.getString("jdbc.password");

        dc.setDriverClassName(driverClass);
        dc.setUrl(jdbcUrl);
        dc.setUsername(username);
        dc.setPassword(password);
    }

    public static Connection getConnection() throws SQLException {
        return dc.getConnection();
    }

    public static DataSource getDataSource(){
        return dc;
    }
}
