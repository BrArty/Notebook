package ua.notebook_shop.run;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@ImportResource({"/WEB-INF/spring-servlet.xml"})
public class Run {

    public static void main(String[] args) {
        SpringApplication.run(Run.class, args);
    }
}
