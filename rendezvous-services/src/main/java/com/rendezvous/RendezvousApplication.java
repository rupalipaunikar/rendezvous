package com.rendezvous;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RendezvousApplication extends ServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(RendezvousApplication.class, args);
    }
}
