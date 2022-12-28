package com.sid.produitservice;


import com.sid.produitservice.enums.Categorie;
import com.sid.produitservice.model.Produit;
import com.sid.produitservice.repository.ProduitRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

@SpringBootApplication
public class ProduitServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProduitServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ProduitRepository produitRepository, RepositoryRestConfiguration restConfiguration)
    {
        return  args ->
        {
            restConfiguration.exposeIdsFor(Produit.class);
            produitRepository.save(new Produit(null,"IPhone13",1200,10, Categorie.C1));
            produitRepository.save(new Produit(null,"Lenovo ",1500,4, Categorie.C2));
            produitRepository.save(new Produit(null,"Imprimanr HP",120,1, Categorie.C3));

            //Affichage des Produit

            produitRepository.findAll().forEach(System.out::println);
        };
    }

}
