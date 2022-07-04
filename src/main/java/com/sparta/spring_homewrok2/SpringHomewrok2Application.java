package com.sparta.spring_homewrok2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SpringHomewrok2Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringHomewrok2Application.class, args);
    }

}
