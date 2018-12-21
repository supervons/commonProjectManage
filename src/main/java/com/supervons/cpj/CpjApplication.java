package com.supervons.cpj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@MapperScan("com.supervons.cpj.entity")
@SpringBootApplication
public class CpjApplication {

    public static void main(String[] args) {
        SpringApplication.run(CpjApplication.class, args);
    }

}

