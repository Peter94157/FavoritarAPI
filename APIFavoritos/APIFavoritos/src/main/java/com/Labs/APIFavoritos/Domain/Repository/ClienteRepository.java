package com.Labs.APIFavoritos.Domain.Repository;

import com.Labs.APIFavoritos.Adapters.Input.Entities.Cliente;
import com.Labs.APIFavoritos.Domain.Entities.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity,Integer> {

    ClienteEntity findById(int id);


    ClienteEntity findByEmail(String email);

    void deleteById(int id);



}
