package com.andrelula.bookstore.config;

import com.andrelula.bookstore.service.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DevConfig {

    @Autowired
    private DBService dbService;

    @Value("${spring.jpa.hibernate.ddl-auto}") //pegar o valor de application-dev.properties se esta como create ou none
    private String strategy;

    @Bean
    public boolean instanciaBaseDeDados(){
        if(strategy.equals("create")){
            this.dbService.instanciaBaseDeDados();
        }
        return false;
    }
}
