package com.produit.produitService.controller;

import com.produit.produitService.model.Produit;
import com.produit.produitService.service.ProduitService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/produits")
public class ProduitController {
    private final ProduitService produitService;
    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }
    @GetMapping("/all")
    public List<Produit> getAll() {
        return produitService.getAllProduits();
    }
    @PostMapping("/create")
    public Produit createProduit(@RequestBody Produit produit) {
        return produitService.createProduit(produit);
    }
}
