package com.Labs.APIFavoritos.Services.Impl;

import com.Labs.APIFavoritos.Adapters.Input.Entities.Cliente;
import com.Labs.APIFavoritos.Domain.Entities.ClienteEntity;
import com.Labs.APIFavoritos.Domain.Repository.ClienteRepository;
import com.Labs.APIFavoritos.Services.UserCase.ServiceClienteUserCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@Service
public class ServiceClienteImpl implements ServiceClienteUserCase {

    @Autowired
    ClienteRepository clienteRepository;

    public Cliente cadatrarCliente(Cliente cliente){
        return cadastroCliente(cliente);
    }


    private Cliente cadastroCliente(Cliente cliente){

        ClienteEntity validaEmail = clienteRepository.findByEmail(cliente.getEmail());

        if(validaEmail != null){return null;}

        ClienteEntity entity = new ClienteEntity();

        entity.setId(cliente.getId());
        entity.setNome(cliente.getNome());
        entity.setEmail(cliente.getEmail());
        entity.setSenha(cliente.getSenha());


        ClienteEntity clientenovo = clienteRepository.save(entity);

        return Cliente.builder()
                .id(clientenovo.getId())
                .nome(clientenovo.getNome())
                .email(clientenovo.getEmail())
                .senha(clientenovo.getSenha())
                .build();

    }


    public Cliente RespostaCliente(Cliente cliente)throws SQLException {
        return MontarRespostaCliente(cliente);
    }

    private Cliente MontarRespostaCliente(Cliente infoCliente)throws SQLException{

        try {
            ClienteEntity cliente = new ClienteEntity();
            cliente.setNome(infoCliente.getNome());
            cliente.setEmail(infoCliente.getEmail());
            cliente.setSenha(infoCliente.getSenha());

            clienteRepository.save(cliente);
            log.info("Dados salvos com Sucesso!");

            return infoCliente;

        }catch (Exception e){
            throw new SQLException("Erro ao salvar no Banco de Dados",e);
        }

    }


    public List<Cliente> ListarClientes()throws SQLException{
        return ListaClientes();
    }

    private List<Cliente> ListaClientes()throws SQLException{

        try {
            List<Cliente> response = new ArrayList<>();
            List<ClienteEntity> entity = clienteRepository.findAll();

            entity.stream().forEach(Entity ->{
                Cliente clienteResponse = Cliente.builder().build();


                clienteResponse.setId(Entity.getId());
                clienteResponse.setNome(Entity.getNome());
                clienteResponse.setEmail(Entity.getEmail());
                clienteResponse.setSenha(Entity.getSenha());


                response.add(clienteResponse);
            });
            return response;

        }catch (Exception e ){
            throw new SQLException("Erro ao buscar no banco de dados",e);
        }
    }

    public Cliente detalharCliente(int id)throws SQLException{
        return detalheCliente(id);
    }

    public Cliente buscarEmailCliente(Cliente cliente){
        return buscaEmailCliente(cliente);
    }
    private Cliente buscaEmailCliente(Cliente cliente){
        ClienteEntity buscaCliente = clienteRepository.findByEmail(cliente.getEmail());

        if(Objects.nonNull(buscaCliente)&& buscaCliente.getEmail().equals(cliente.getEmail())){
            return Cliente.builder()
                    .nome(buscaCliente.getNome())
                    .email(buscaCliente.getEmail())
                    .senha(buscaCliente.getSenha())
                    .build();
        }

        return null;

    }

    private Cliente detalheCliente(int id)throws SQLException{

        System.out.println("ID dentro da função detalhe "+id);
        ClienteEntity entity = clienteRepository.findById(id);

        try{
            return Cliente.builder()
                    .id((entity.getId()))
                    .nome(entity.getNome())
                    .email(entity.getEmail())
                    .build();
        }catch(Exception e){
            throw new SQLException ("Não foi possivel encontrar o produto no Banco de dados");
        }
    }



    public Cliente deletarCliente(int id )throws  SQLException{
        return deletaCliente(id);
    }
    private Cliente deletaCliente(int id) throws SQLException{
        try{
            System.out.println(id);
            clienteRepository.deleteById(id);
        }catch (Exception e){
            throw new SQLException("Produto não encontrado no Banco de dados",e);
        }
        return null;
    }

    public Cliente atualizarCliente(Cliente cliente, int id){
        return atualizandoCliente(cliente,id);
    }

    private Cliente atualizandoCliente(Cliente cliente, int id){
        Integer intId = (int)(long) id;
        Optional<ClienteEntity> ClienteExistente = (clienteRepository.findById(intId));

        if(ClienteExistente.isPresent()){
            ClienteEntity retornoExistente = ClienteExistente.get();
            retornoExistente.setNome(cliente.getNome());
            retornoExistente.setEmail(cliente.getEmail());
            ClienteEntity clienteAtualizado = clienteRepository.save(retornoExistente);

            return Cliente.builder()
                    .nome(clienteAtualizado.getNome())
                    .email(clienteAtualizado.getEmail())
                    .build();
        }

        return null;

    }





}
