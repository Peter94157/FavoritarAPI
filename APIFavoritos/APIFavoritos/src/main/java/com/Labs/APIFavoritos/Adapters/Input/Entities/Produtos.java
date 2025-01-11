package com.Labs.APIFavoritos.Adapters.Input.Entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Produtos {
    private int Id;
    private float price;
    private String UrlImage;
    private String Brande;
    private String Tittle;
    private float ReviewScore;

}
