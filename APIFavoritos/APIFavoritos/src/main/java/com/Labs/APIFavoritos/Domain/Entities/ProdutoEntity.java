package com.Labs.APIFavoritos.Domain.Entities;


import jakarta.persistence.*;
import lombok.*;



@Getter
@Setter
@Table(name = "Produtos")
@Entity
public class ProdutoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="Id")
    private int Id;
    @Column(name = "price")
    private float price;
    @Column(name = "UrlImage")
    private String UrlImage;
    @Column(name = "Brande")
    private String Brande;
    @Column(name = "tittle")
    private String tittle;
    @Column(name = "ReviewScore")
    private float ReviewScore;

}
