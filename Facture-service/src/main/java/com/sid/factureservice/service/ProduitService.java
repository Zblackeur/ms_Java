package com.sid.factureservice.service;

import com.sid.factureservice.model.Produit;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name ="PRODUIT-SERVICE")
public interface ProduitService {

    @GetMapping("/produits/{id}")
    public Produit findProduitById(@PathVariable(name = "id") Long id);

    @GetMapping("/produits")
    public PagedModel<Produit> fiddAllProduit();


}
