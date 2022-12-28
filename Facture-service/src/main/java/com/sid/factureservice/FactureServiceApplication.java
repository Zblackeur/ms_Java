package com.sid.factureservice;

import com.sid.factureservice.model.Client;
import com.sid.factureservice.model.Facture;
import com.sid.factureservice.model.FactureLigne;
import com.sid.factureservice.model.Produit;
import com.sid.factureservice.repository.FactureLigneRepository;
import com.sid.factureservice.repository.FactureRepository;
import com.sid.factureservice.service.ClientService;
import com.sid.factureservice.service.ProduitService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.PagedModel;

import java.util.Date;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients
public class FactureServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(FactureServiceApplication.class, args);
    }

   @Bean
    CommandLineRunner start(FactureRepository factureRepository , FactureLigneRepository factureLigneRepository, ClientService clientService, ProduitService produitService)
   {
       return  args ->
       {
           //Rechercher dun Client par ID
           Client c1 = clientService.findCleintById(1L);
           System.out.println("******************************");
           System.out.println("ID= "+c1.getId());
           System.out.println("Name= "+c1.getName());
           System.out.println("******************************");

           //Rechercher dun produit par ID
           Produit p = produitService.findProduitById(1L);
           //Produit p2 = produitService.findProduitById(2L);
           //Produit p3 = produitService.findProduitById(3L);
           System.out.println("******************************");
           System.out.println("ID= "+p.getId());
           System.out.println("Name= "+p.getName());
           System.out.println("Name= "+p.getCategorie());
           System.out.println("Name= "+p.getPrice());
           System.out.println("Name= "+p.getQuantite());
           System.out.println("******************************");




           Facture fact1 =  factureRepository.save(new Facture(null,new Date(), c1.getId(),null, null));
           PagedModel<Produit> produits = produitService.fiddAllProduit();

           produits.getContent().forEach( px -> {
               factureLigneRepository.save(new FactureLigne(null, px.getId(),null, px.getPrice(), 10,fact1));
           });

           /*
           factureLigneRepository.save(new FactureLigne(null, p.getId(), p.getPrice(), p.getQuantite(),fact1));
           factureLigneRepository.save(new FactureLigne(null, p2.getId(), p2.getPrice(), p2.getQuantite(),fact1));
           factureLigneRepository.save(new FactureLigne(null, p3.getId(), p3.getPrice(), p3.getQuantite(),fact1));
           //factureLigneRepository.save(new FactureLigne(null,2L,45,1,fact1));
           */

         /*  Facture fact2 =  factureRepository.save(new Facture(null,new Date(),1L,null));
           factureLigneRepository.save(new FactureLigne(null,4L,35,3,fact2));
           factureLigneRepository.save(new FactureLigne(null,2L,5,12,fact2));
           factureLigneRepository.save(new FactureLigne(null,3L,3,7,fact2));

          */

           //LISTE DE FACTURE
           //factureRepository.findAll().forEach(System.out::println);
       };
   }

}
