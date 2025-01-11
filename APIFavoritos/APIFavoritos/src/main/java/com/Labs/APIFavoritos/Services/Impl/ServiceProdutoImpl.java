package com.Labs.APIFavoritos.Services.Impl;

import com.Labs.APIFavoritos.Adapters.Input.Entities.Cliente;
import com.Labs.APIFavoritos.Adapters.Input.Entities.Favorito;
import com.Labs.APIFavoritos.Adapters.Input.Entities.Produtos;
import com.Labs.APIFavoritos.Domain.Entities.ClienteEntity;
import com.Labs.APIFavoritos.Domain.Entities.FavoritosEntity;
import com.Labs.APIFavoritos.Domain.Entities.ProdutoEntity;
import com.Labs.APIFavoritos.Domain.Repository.ClienteRepository;
import com.Labs.APIFavoritos.Domain.Repository.FavoritoRepository;
import com.Labs.APIFavoritos.Domain.Repository.ProdutoRepository;
import com.Labs.APIFavoritos.Services.UserCase.ServiceProdutoUserCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.ObjectError;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@Service
public class ServiceProdutoImpl implements ServiceProdutoUserCase {
    @Autowired
    ProdutoRepository produtoRepository;

    @Autowired
    FavoritoRepository favoritoRepository;

    @Autowired
    ClienteRepository clienteRepository;


    //Cadastro dos produtos
    private Produtos CadastroProduto(Produtos produto){

        ProdutoEntity valida = produtoRepository.findByTittle(produto.getTittle());

        if (Objects.nonNull(valida)){
            return null;
        }

        ProdutoEntity entities = new ProdutoEntity();

        entities.setPrice(produto.getPrice());
        entities.setUrlImage(produto.getUrlImage());
        entities.setBrande(produto.getBrande());
        entities.setTittle(produto.getTittle());
        entities.setReviewScore(produto.getReviewScore());

        ProdutoEntity novoProduto = produtoRepository.save(entities);


        return Produtos.builder()
                .price(novoProduto.getPrice())
                .Tittle(novoProduto.getTittle())
                .ReviewScore(novoProduto.getReviewScore())
                .UrlImage(novoProduto.getUrlImage())
                .Brande(novoProduto.getBrande())
                .build();
    }

    public Produtos CadastrarProduto(Produtos produto){
        return CadastroProduto(produto);
    }



    public List<Favorito> listarFavoritos(String emailCliente) throws SQLException{
        return listaFavoritos(emailCliente);
    }
    private List<Favorito> listaFavoritos(String email)throws SQLException {

        try{

            List<Favorito> response = new ArrayList<>();
            List<FavoritosEntity> entities = favoritoRepository.findAllByEmail(email);

            entities.stream().forEach(Entity->{
                Favorito favoritoResponse = Favorito.builder().build();

                favoritoResponse.setSKU(Entity.getSKU());
                favoritoResponse.setTittle(Entity.getTitlle());

                response.add(favoritoResponse);

            } );

            return response;
        }catch(Exception e){
            throw new SQLException("Erro ao buscar produtos favoritos");

        }

    }




    public Produtos RespostaFrontProduto(Produtos infoProduto)throws SQLException{
        return MontarRespostaProduto(infoProduto);
    }


    private Produtos MontarRespostaProduto(Produtos infoProduto)throws SQLException{

        try {
            ProdutoEntity produto = new ProdutoEntity();
            produto.setReviewScore(infoProduto.getReviewScore());
            produto.setTittle(infoProduto.getTittle());
            produto.setBrande(infoProduto.getBrande());
            produto.setPrice(infoProduto.getPrice());
            produto.setUrlImage(infoProduto.getUrlImage());
            produto.setId(infoProduto.getId());

            produtoRepository.save(produto);
            log.info("Dados salvos com Sucesso!");

            return infoProduto;
        }catch (Exception e){
            throw new SQLException("Erro ao salvar no Banco de Dados",e);
        }

    }

    public List<Produtos> ListarProdutos()throws SQLException{
        return ListaProdutos();
    }

    private List<Produtos> ListaProdutos()throws SQLException{

        try {
            List<Produtos> response = new ArrayList<>();
            List<ProdutoEntity> entity = produtoRepository.findAll();

            entity.stream().forEach(Entity ->{
                Produtos produtoResponse = Produtos.builder().build();

                produtoResponse.setBrande(Entity.getBrande());
                produtoResponse.setTittle(Entity.getTittle());
                produtoResponse.setPrice(Entity.getPrice());
                produtoResponse.setReviewScore(Entity.getReviewScore());
                produtoResponse.setUrlImage(Entity.getUrlImage());
                produtoResponse.setId(Entity.getId());

                response.add(produtoResponse);
            });
            return response;

        }catch (Exception e ){
            throw new SQLException("Erro ao buscar no banco de dados",e);
        }
    }

    public Produtos detalharProduto(int id)throws SQLException{
        return detalheProduto(id);
    }

    private Produtos detalheProduto(int id)throws SQLException{
        ProdutoEntity entity = produtoRepository.findById(id);

        try{
            return Produtos.builder()
                    .Id(entity.getId())
                    .Tittle(entity.getTittle())
                    .price(entity.getPrice())
                    .Brande(entity.getBrande())
                    .UrlImage(entity.getUrlImage())
                    .ReviewScore(entity.getReviewScore())
                    .build();


        }catch(Exception e){
            throw new SQLException ("Não foi possivel encontrar o produto no Banco de dados");
        }
    }



    public Produtos deletarProduto(int id )throws  SQLException{
        return deletaProduto(id);
    }
    private Produtos deletaProduto(int id) throws SQLException{
        long iid = (int)(long) id;
        try{
            produtoRepository.deleteById(id);
        }catch (Exception e){
            throw new SQLException("Produto não encontrado no Banco de dados",e);
        }
        return null;
    }


    public Favorito FavoritarProduto(Favorito favorito){
        return ProdutoFavorito(favorito);
    }

    private Favorito ProdutoFavorito(Favorito favorito){

        ClienteEntity validaCliente = clienteRepository.findByEmail(favorito.getEmail());
        ProdutoEntity validaProduto = produtoRepository.findByTittle(favorito.getTittle());

        if(Objects.isNull(validaProduto)&&Objects.isNull(validaCliente)){
            return null;
        }

        List<FavoritosEntity> validaLista = favoritoRepository.findAllByEmail(validaCliente.getEmail());

        System.out.println(validaLista);


        for (int i = 0;i<validaLista.size();i++ ) {
            if (validaLista.get(i).getTitlle().equals(favorito.getTittle())){
                return null;

            }

        }
        FavoritosEntity entities = new FavoritosEntity();

        entities.setId(favorito.getId());
        entities.setSKU(validaProduto.getId());
        entities.setTitlle(favorito.getTittle());
        entities.setNomeCliente(validaCliente.getNome());
        entities.setEmail(validaCliente.getEmail());


        FavoritosEntity novoProduto = favoritoRepository.save(entities);


        return Favorito.builder()
                .id(novoProduto.getId())
                .nomeCliente(novoProduto.getNomeCliente())
                .SKU(novoProduto.getSKU())
                .tittle(novoProduto.getTitlle())
                .email(novoProduto.getEmail())
                .build();


    }



}
