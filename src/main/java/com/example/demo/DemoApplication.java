package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(DemoApplication.AppProps.class)
public class DemoApplication {

    private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @ConfigurationProperties(prefix = "app")
    public record AppProps(
            String greetingMessage,
            int repeat
    ) {}

    @Bean
    CommandLineRunner runner(AppProps props) {
        return args -> {
            for (int i = 0; i < props.repeat(); i++) {
                log.info("app.greetingMessage = {}", props.greetingMessage());
            }
        };
    }
}
