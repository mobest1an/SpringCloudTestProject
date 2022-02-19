package com.mobest1an.eurekamicro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaMicroApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaMicroApplication.class, args);
    }
}
