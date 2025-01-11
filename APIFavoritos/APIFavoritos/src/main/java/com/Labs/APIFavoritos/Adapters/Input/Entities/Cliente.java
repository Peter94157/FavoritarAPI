package com.Labs.APIFavoritos.Adapters.Input.Entities;

import lombok.*;

@Getter
@Setter
@Builder
public class Cliente {
    private int id;
    private String nome;
    private String email;
    private String senha;

}
