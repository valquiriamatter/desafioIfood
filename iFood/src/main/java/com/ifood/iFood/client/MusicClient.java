package com.ifood.iFood.client;

import com.ifood.iFood.models.spotify.Spotify;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

//postman

@FeignClient(value="spotify", url = "https://api.spotify.com/v1/browse/categories/", configuration = TokenClientConfiguration.class)
public interface MusicClient {

    @GetMapping("/{categoria}/playlists")
    Spotify getSpotify(
            @RequestHeader(value = "Authorization") String token,
            @PathVariable("categoria")String categoria);

}

