package com.example.springboothadoopconntector;

import org.apache.log4j.BasicConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootHadoopConntectorApplication {

    public static void main(String[] args) {
        BasicConfigurator.configure();
        SpringApplication.run(SpringbootHadoopConntectorApplication.class, args);
    }

}
