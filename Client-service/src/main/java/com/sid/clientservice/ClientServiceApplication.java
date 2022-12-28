package com.sid.clientservice;

import com.sid.clientservice.model.Client;
import com.sid.clientservice.repository.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ClientServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ClientRepository clientRepository)
    {
        return  args ->
        {
            clientRepository.save(new Client(null,"Zambo"));
            clientRepository.save(new Client(null,"OUSMANOU"));

            //Affichage des client

            clientRepository.findAll().forEach(System.out::println);
        };
    }

}
