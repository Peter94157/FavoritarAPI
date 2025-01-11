package com.Labs.APIFavoritos.Adapters.Output.useCase;

public interface RedisUseCase {


    void salvarDadosRedis(int chave, String valor, long tempoDeExpiracaoEmSegundos);

    String recuperarDadosRedis(int chave);
}
