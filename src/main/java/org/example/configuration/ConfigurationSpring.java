package org.example.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = "org.example")
@EnableTransactionManagement
@PropertySource(value = {"classpath:hibernate.properties"})
public class ConfigurationSpring {

    @Autowired
    private Environment env;

}



