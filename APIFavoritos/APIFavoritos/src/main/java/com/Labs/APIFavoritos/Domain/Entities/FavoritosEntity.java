package com.Labs.APIFavoritos.Domain.Entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
@Table(name = "ListaFavoritos")
@Entity
public class FavoritosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "SKU")
    private int SKU;
    @Column(name = "tittle")
    private String titlle;
    @Column(name = "nomeCliente")
    private String nomeCliente;

    @Column(name = "email")
    private String email;
}
