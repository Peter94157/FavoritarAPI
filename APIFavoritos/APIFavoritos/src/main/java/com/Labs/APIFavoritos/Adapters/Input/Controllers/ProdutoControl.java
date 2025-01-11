package com.Labs.APIFavoritos.Adapters.Input.Controllers;

import com.Labs.APIFavoritos.Adapters.Input.Entities.Favorito;
import com.Labs.APIFavoritos.Adapters.Input.Entities.Produtos;
import com.Labs.APIFavoritos.Services.UserCase.ServiceProdutoUserCase;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

@Slf4j
@RestController
@RequestMapping("/Produtos")
public class ProdutoControl {

    @Autowired
    ServiceProdutoUserCase produtoUserCase;


    @PostMapping("")
    public ResponseEntity<Produtos> post(@RequestBody Produtos infoProduto){

        Produtos novoprodutocadastrado = produtoUserCase.CadastrarProduto(infoProduto);

        if(Objects.isNull(novoprodutocadastrado)){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(novoprodutocadastrado);
        }else {
            log.info("Produto cadastrado com sucesso!");
            return ResponseEntity.status(HttpStatus.CREATED).body(infoProduto);

        }


    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Produtos>> getProdutos() throws SQLException {

        List<Produtos> detalheProduto = produtoUserCase.ListarProdutos();
        if (Objects.isNull(detalheProduto)){
            return (ResponseEntity<List<Produtos>>) ResponseEntity.notFound();
        }
        return ResponseEntity.status(HttpStatus.OK).body(detalheProduto);

    }

    @GetMapping("/get/{id}")
    public ResponseEntity <Produtos> getProduto(@PathVariable int id)throws SQLException{
        Produtos produto = produtoUserCase.detalharProduto(id);

        if(Objects.isNull(produto)){
            return (ResponseEntity<Produtos>) ResponseEntity.notFound();
        }
        return ResponseEntity.status(HttpStatus.OK).body(produto);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity <Produtos> deleteProduto(@PathVariable int id)throws SQLException{
        Produtos produto = produtoUserCase.deletarProduto(id);

        return ResponseEntity.status(HttpStatus.OK).body(produto);
    }

    @PostMapping("/favoritar")
    public ResponseEntity <Favorito> favoritarProduto(@RequestBody Favorito body){
        Favorito fav = produtoUserCase.FavoritarProduto(body);
        if (Objects.isNull(fav)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(fav);
        }

        return ResponseEntity.status(HttpStatus.OK).build();

    }

    @GetMapping("/getFavoritos/{email}")
    public ResponseEntity <List<Favorito>> getFavoritos(@PathVariable String email) throws SQLException {
        List<Favorito> favoritoList = produtoUserCase.listarFavoritos(email);
        if (Objects.isNull(favoritoList)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(favoritoList);



    }


}
