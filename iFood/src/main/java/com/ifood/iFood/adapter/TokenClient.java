package com.ifood.iFood.adapter;

import com.ifood.iFood.models.autorizacao.Autorizacao;
import com.ifood.iFood.models.autorizacao.Usuario;
import feign.Param;
import feign.form.FormProperty;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@FeignClient(value="token", url = "https://accounts.spotify.com/api/token", configuration = TokenClientConfiguration.class)
public interface TokenClient {

    @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    Autorizacao getAutorizacao(
            @RequestHeader(value = "Authorization") String credentials,
            @RequestHeader(value = "Content-Type") String contentType,
            @RequestBody Usuario usuario
            );



//    @FeignClient(value="spotify", url = "https://api.spotify.com/v1/browse/categories/")
//    public interface MusicClient {
//
//        @GetMapping("/{categoria}/playlists")
//        Spotify getSpotify(
//                @RequestHeader(value = "Authorization") String token,
//                @PathVariable("categoria")String categoria);









    }

