package ua.notebook_shop.run;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.devtools.autoconfigure.DevToolsDataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, DevToolsDataSourceAutoConfiguration.class, DataSourceProperties.class})
@Configuration
@ComponentScan
@ImportResource({"WEB-INF/spring-servlet.xml"})
public class Run {

    public static void main(String[] args) {
        SpringApplication.run(Run.class, args);
    }
}
