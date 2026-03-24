package com.produit.produitService.service;

import com.produit.produitService.model.Produit;
import com.produit.produitService.repository.ProduitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

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

    public Produit getProduitById(Long id) {
         Optional<Produit> optionalProduit= produitRepository.findById(id);
         if(optionalProduit.isEmpty()) {
             throw new RuntimeException("erreur");
         }

        return optionalProduit.get();
    }

    public String deleteProduitById(Long id) {
        Optional<Produit> optionalProduit= produitRepository.findById(id);
        if(optionalProduit.isEmpty()) {
            throw new RuntimeException("erreur");
        }
          produitRepository.delete(optionalProduit.get());
        return "Produit Successfully deleted";
    }

    public Produit updateProduit(long id, Produit produit) {
        Optional<Produit> optionalProduit= produitRepository.findById(id);
        if(optionalProduit.isEmpty()) {
            throw new RuntimeException("cannot edit");
        }
        Produit editProduit=optionalProduit.get();
        editProduit.setName(produit.getName());
        editProduit.setPrice(produit.getPrice());
        return produitRepository.save(editProduit);
    }
}
