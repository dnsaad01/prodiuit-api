package com.produit.produitservice.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "produit")
public class Produit {
    @Id
    @GeneratedValue
    private long id;
    private String nom;
    private Double prix;
}
