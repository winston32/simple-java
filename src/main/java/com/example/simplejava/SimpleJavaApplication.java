package com.example.simplejava;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SimpleJavaApplication {

    private static final Logger log = LoggerFactory.getLogger(SimpleJavaApplication.class);

    public static void main(String[] args) {
        var ctx = SpringApplication.run(SimpleJavaApplication.class, args);
        log.info("SimpleJavaApplication started with profiles: {}", String.join(",", ctx.getEnvironment().getActiveProfiles()));
    }
}