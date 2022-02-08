package com.ifood.iFood.adapter;

import com.ifood.iFood.models.autorizacao.Autorizacao;
import com.ifood.iFood.models.Spotify;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

//postman

@FeignClient(value="spotify", url = "https://api.spotify.com/v1/browse/categories/")
public interface MusicClient {

    @GetMapping("/{categoria}/playlists")
    Spotify getSpotify(
            @RequestHeader(value = "Authorization") String token,
            @PathVariable("categoria")String categoria);


//    @PostMapping
//    Autorizacao getAutorizacao(
//            @RequestHeader(value = "Authorization", required = true) String credentials,
//            @RequestHeader(value = "Content-Type", required = true) String contentType);






}

