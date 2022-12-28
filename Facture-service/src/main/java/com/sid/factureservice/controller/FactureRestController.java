package com.sid.factureservice.controller;

import com.sid.factureservice.model.Facture;
import com.sid.factureservice.repository.FactureLigneRepository;
import com.sid.factureservice.repository.FactureRepository;
import com.sid.factureservice.service.ClientService;
import com.sid.factureservice.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FactureRestController {

    @Autowired
    private FactureRepository factureRepository;

    @Autowired
    private FactureLigneRepository factureLigneRepository;

    @Autowired
    private ClientService clientService;

    @Autowired
    private ProduitService produitService;


    @GetMapping("/fullFacture/{id}")
    public Facture  getFacture(@PathVariable(name = "id") Long id)
    {
        Facture fact =  factureRepository.findById(id).get();

        fact.setClient(clientService.findCleintById(fact.getClientID()));

        fact.getFactureLignes().forEach(fl ->
        {
            fl.setProduit(produitService.findProduitById(fl.getProduitId()));
        });
        return  fact;
    }


}
