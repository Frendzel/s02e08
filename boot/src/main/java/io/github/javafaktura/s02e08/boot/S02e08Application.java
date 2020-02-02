package io.github.javafaktura.s02e08.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class S02e08Application {
    public static void main(String[] args) {
        SpringApplication.run(S02e08Application.class, args);
    }
}
