package com.todouno.hulkstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@ComponentScan(basePackages = {
    "com.todouno.hulkstore"
})

public class HulkStoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(HulkStoreApplication.class, args);
    }

}
