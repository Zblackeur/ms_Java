package com.sid.factureservice.model;

import com.sid.factureservice.enums.Categorie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Produit {


    private Long id;

    private String name;

    private double price;

    private Integer quantite;

    private Categorie categorie;

}

