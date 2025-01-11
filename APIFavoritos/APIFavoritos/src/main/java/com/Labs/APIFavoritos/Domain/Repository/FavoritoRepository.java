package com.Labs.APIFavoritos.Domain.Repository;


import com.Labs.APIFavoritos.Domain.Entities.FavoritosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FavoritoRepository extends JpaRepository<FavoritosEntity,Integer> {

    List <FavoritosEntity> findAllByEmail(String Email);


}
