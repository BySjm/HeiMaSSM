package cn.bysjm.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;

@Configuration
@ComponentScan("cn.bysjm")
@Import({DataSourceConfig.class})
public class SpringConfig {

    @Bean
    public QueryRunner getQueryRunner(@Autowired DataSource dataSource) {
        QueryRunner queryRunner = new QueryRunner(dataSource);
        return queryRunner;
    }

}
