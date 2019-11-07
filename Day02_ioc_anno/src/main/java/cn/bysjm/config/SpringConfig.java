package cn.bysjm.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("cn.bysjm")
@PropertySource("classpath:jdbc.properties")
public class SpringConfig {

}
