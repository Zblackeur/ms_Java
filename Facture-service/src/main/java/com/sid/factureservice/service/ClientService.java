package com.sid.factureservice.service;

import com.sid.factureservice.model.Client;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "CLIENT-SERVICE")
public interface ClientService {

    @GetMapping("/clients/{id}")
    public Client findCleintById(@PathVariable(name = "id") Long id);
}
