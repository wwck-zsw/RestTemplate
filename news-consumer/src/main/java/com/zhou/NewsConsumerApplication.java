package com.zhou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class NewsConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(NewsConsumerApplication.class, args);
    }

}
