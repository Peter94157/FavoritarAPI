package com.Labs.APIFavoritos.Adapters.Input.Entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Favorito {
    private int id;
    private int SKU;
    private String tittle;
    private String nomeCliente;
    private String email;

}
