package com.Labs.APIFavoritos.Adapters.Input.Controllers;

import com.Labs.APIFavoritos.Adapters.Input.Entities.Cliente;
import com.Labs.APIFavoritos.Services.UserCase.ServiceClienteUserCase;
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
@RequestMapping("/Cliente")
public class ClienteControl {



    @Autowired
    ServiceClienteUserCase respostaUserCase;



    @GetMapping("/getAll")
    public ResponseEntity <List<Cliente>> getAll() throws SQLException {
        List<Cliente> detalheCliente = respostaUserCase.ListarClientes();

        if (Objects.isNull(detalheCliente)){
            return (ResponseEntity<List<Cliente>>) ResponseEntity.notFound();
        }
        return ResponseEntity.status(HttpStatus.OK).body(detalheCliente);
    }


    @GetMapping("/get/{id}")
    public ResponseEntity <Cliente> getCliente(@PathVariable int id)throws SQLException {
        System.out.println("o ID é este ->>>>> "+id);

        Cliente cliente = respostaUserCase.detalharCliente(id);

        if(Objects.isNull(cliente)){
            return (ResponseEntity<Cliente>) ResponseEntity.notFound();
        }

        return ResponseEntity.status(HttpStatus.OK).body(cliente);


    }

    @PostMapping("")
    public ResponseEntity <Cliente> post(@RequestBody Cliente cliente){

        System.out.println("Cliente que vem - "+cliente.toString());
        Cliente clienteNovo = respostaUserCase.cadatrarCliente(cliente);
        if (Objects.isNull(clienteNovo)){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        System.out.println("Novo cliente - "+clienteNovo);

        return ResponseEntity.status(HttpStatus.CREATED).body(clienteNovo);





     }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity <Cliente> deleteCliente(@PathVariable int id) throws SQLException {
        Cliente cliente = respostaUserCase.deletarCliente(id);

        return ResponseEntity.status(HttpStatus.OK).body(cliente);



    }
    @PutMapping("/put/{id}")
    public ResponseEntity<Cliente> AtualizarCliente(@PathVariable int id, @RequestBody Cliente cliente){

        Cliente clienteAtualizado = respostaUserCase.atualizarCliente(cliente,id);

        if(Objects.isNull(clienteAtualizado)){
            return ResponseEntity.status(HttpStatus.OK).body(clienteAtualizado);

        }

        return ResponseEntity.status(HttpStatus.OK).body(clienteAtualizado);
    }

}
