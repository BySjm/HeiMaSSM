package cn.bysjm.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@ComponentScan("cn.bysjm")
@EnableAspectJAutoProxy
public class SpringConfig {
}
