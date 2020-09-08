package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
//configuram
@Configuration
//scanam
@ComponentScan (basePackages = {"business.service","persistence.dao","entryPoint"})
public class SpringConfiguration {
}
