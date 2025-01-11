package com.Labs.APIFavoritos.Services.UserCase;

import com.Labs.APIFavoritos.Adapters.Input.Entities.Cliente;

import java.sql.SQLException;
import java.util.List;

public interface ServiceClienteUserCase {

    Cliente cadatrarCliente(Cliente cliente);
    Cliente RespostaCliente(Cliente cliente)throws SQLException;

    List<Cliente> ListarClientes()throws SQLException;

    Cliente detalharCliente(int id)throws SQLException;
    Cliente buscarEmailCliente(Cliente cliente);

    Cliente deletarCliente(int id )throws  SQLException;

    Cliente atualizarCliente(Cliente cliente, int id);

}
