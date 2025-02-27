package com.Labs.APIFavoritos.Adapters.Output.useCaseImpl;

import com.Labs.APIFavoritos.Adapters.Output.useCase.RedisUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
public class RedisUseCaseImpl implements RedisUseCase {

    @Autowired
    private final RedisTemplate<String,String> redisTemplate;

    public RedisUseCaseImpl(){
        redisTemplate = new RedisTemplate<>();
    }

    public void salvarDadosRedis(int chave, String valor, long tempoDeExpiracaoEmSegundos){
        redisTemplate.opsForValue().set(String.valueOf(chave),valor);
        redisTemplate.expire(String.valueOf(chave), Duration.ofSeconds(tempoDeExpiracaoEmSegundos));

    }

    public String recuperarDadosRedis(int chave){
        return redisTemplate.opsForValue().get(String.valueOf(chave));
    }


}
