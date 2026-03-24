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
    @GetMapping("/{id}")
    public Produit getProduitById(@PathVariable Long id) {
          return produitService.getProduitById(id);
    }
    @DeleteMapping("/{id}")
    public String deleteProduitById(@PathVariable Long id) {
        return produitService.deleteProduitById(id);
    }
    @PutMapping("/{id}")
    public Produit updateProduit(@PathVariable Long id, @RequestBody Produit produit) {
        return produitService.updateProduit(id, produit);
    }
}
