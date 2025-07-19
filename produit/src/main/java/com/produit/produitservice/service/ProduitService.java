package com.produit.produitservice.service;


import com.produit.produitservice.model.Produit;
import com.produit.produitservice.repository.ProduitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProduitService {

    private final ProduitRepository produitRepository;


    public List<Produit> getAllProduits() {
        return produitRepository.findAll();
    }

    public Produit createProduit(Produit produit) {
        return produitRepository.save(produit);
    }

    public Produit getProduitById(long id) {
        Optional<Produit> optionalProduit = produitRepository.findById(id);


        if (optionalProduit.isEmpty()){
            throw new RuntimeException("Produit n'existe pas");

        }
        return optionalProduit.get();

    }

    public String deleteProduitById(long idProduit) {
        Optional<Produit> optionalProduit = produitRepository.findById(idProduit);

        if (optionalProduit.isEmpty()){
            throw new RuntimeException("supprime produit n'existe pas");

        }
        produitRepository.delete(optionalProduit.get());
        return "Produit supprimer avec succes";


    }

    public Produit editProduit(long id, Produit produit) {
        Optional<Produit> optionalProduit = produitRepository.findById(id);
        if (optionalProduit.isEmpty()){
            throw new RuntimeException("Produit n'existe pas");
        }
        Produit produitAModifier = optionalProduit.get();
        produitAModifier.setNom(produit.getNom());
        produitAModifier.setPrix(produit.getPrix());
        return produitRepository.save(produitAModifier);
    }
}
