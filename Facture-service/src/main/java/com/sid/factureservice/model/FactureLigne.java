package com.sid.factureservice.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FactureLigne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    private Long produitId;

    @Transient
    private Produit produit;

    private  double price;

    private Integer quantite;


    @ManyToOne
    @JoinColumn(name = "facture_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private  Facture facture;
}
