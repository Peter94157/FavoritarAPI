package com.Labs.APIFavoritos.Domain.Repository;


import com.Labs.APIFavoritos.Domain.Entities.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoEntity,Integer> {
    //ProdutoEntity findByTittle(String nome);


    ProdutoEntity findByTittle(String tittle);
    ProdutoEntity findById(int id);
}
