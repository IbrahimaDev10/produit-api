package com.produit.produitService.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import jakarta.persistence.Table;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name="produit")
public class Produit {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private double price;
}
