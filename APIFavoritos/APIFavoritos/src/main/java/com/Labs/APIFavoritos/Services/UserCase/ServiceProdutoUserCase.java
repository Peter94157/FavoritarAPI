package com.Labs.APIFavoritos.Services.UserCase;

import com.Labs.APIFavoritos.Adapters.Input.Entities.Cliente;
import com.Labs.APIFavoritos.Adapters.Input.Entities.Favorito;
import com.Labs.APIFavoritos.Adapters.Input.Entities.Produtos;

import java.sql.SQLException;
import java.util.List;

public interface ServiceProdutoUserCase {

    Produtos CadastrarProduto(Produtos produto);

    Favorito FavoritarProduto(Favorito favorito);


    List<Favorito> listarFavoritos(String emailCliente) throws SQLException;

    Produtos RespostaFrontProduto(Produtos infoProduto)throws SQLException;

    List<Produtos> ListarProdutos()throws SQLException;

    Produtos detalharProduto(int id)throws SQLException;

    Produtos deletarProduto(int id )throws  SQLException;


}
