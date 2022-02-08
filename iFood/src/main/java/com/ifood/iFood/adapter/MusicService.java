package com.ifood.iFood.adapter;

import com.ifood.iFood.models.Spotify;
import com.ifood.iFood.models.autorizacao.Autorizacao;
import com.ifood.iFood.models.autorizacao.Usuario;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/music")
public class MusicService {

    private final MusicClient musicClient;
    private TokenService tokenService;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{categoria}", method = RequestMethod.GET)
    public Spotify getSpotify(@RequestBody Usuario usuario, @PathVariable String categoria) {

        Autorizacao autorizacao = tokenService.getAutorizacao(usuario);
        String token = "Bearer " + autorizacao.getTokenAcesso();

        return musicClient.getSpotify(token, categoria);
    }




//    @ResponseStatus(HttpStatus.OK)
//    @RequestMapping(value = "/{categoria}", method = RequestMethod.GET)
//    public Spotify getSpotify(@PathVariable String categoria) {
//
//        //chamar o metodo que retorna o token
//        String token = "Bearer BQCJTUU_X9S4o4aqk2Bi4I0lvWu53fSnmYxge7ndI0Dhb6ky-BfkZhmB5ihlGohqVFrxh9PnyAC8Kb4Fd8U";
//        return musicClient.getSpotify(token, categoria);
//    }




}


