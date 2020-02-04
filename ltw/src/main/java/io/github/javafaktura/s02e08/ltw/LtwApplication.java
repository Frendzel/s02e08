package io.github.javafaktura.s02e08.ltw;

import org.aspectj.lang.Aspects;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class LtwApplication {
    @RequestMapping("/")
    public String home() {
        return "Hello World";
    }

    @Bean
    public Interceptor interceptor() {
        return Aspects.aspectOf(Interceptor.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(LtwApplication.class, args);
    }

}
