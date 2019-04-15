package org.softuni.carpartsshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CarpartsshopApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarpartsshopApplication.class, args);
    }

}
