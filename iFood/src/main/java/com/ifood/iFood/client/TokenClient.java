package com.ifood.iFood.client;

import com.ifood.iFood.models.autorizacao.Autorizacao;
import com.ifood.iFood.models.autorizacao.Usuario;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;


@FeignClient(value="token", url = "https://accounts.spotify.com/api/token", configuration = TokenClientConfiguration.class)
public interface TokenClient {

    @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    Autorizacao getAutorizacao(
            @RequestHeader(value = "Authorization") String credentials,
            @RequestHeader(value = "Content-Type") String contentType,
            @RequestBody Usuario usuario
            );

    }

