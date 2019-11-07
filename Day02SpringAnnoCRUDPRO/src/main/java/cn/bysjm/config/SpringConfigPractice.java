package cn.bysjm.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("cn.bysjm")
@PropertySource("classpath:jdbc.properties")
public class SpringConfigPractice {

//    @Bean
//    @Autowired
//    @Import({DataSourceConfig.class})

}
