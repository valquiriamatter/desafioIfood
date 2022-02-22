package com.ifood.iFood.controllers;

import com.ifood.iFood.controllers.autorizacao.TokenController;
import com.ifood.iFood.controllers.spotify.MusicController;
import com.ifood.iFood.controllers.temperatura.TemperaturaController;
import com.ifood.iFood.models.spotify.Spotify;
import com.ifood.iFood.models.temperatura.Temperatura;
import com.ifood.iFood.models.autorizacao.Usuario;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/desafio")
public class DesafioController {

    private final TemperaturaController temperaturaController;
    private final TokenController tokenController;
    private final MusicController musicService;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{nomeCidade}", method = RequestMethod.GET)
    public Spotify getSpotify(@PathVariable String nomeCidade, @RequestBody Usuario usuario) {

        Temperatura temperatura = temperaturaController.getTemperatura(nomeCidade);
        String categoria = retornaCategoria(temperatura);

//        Autorizacao autorizacao = tokenService.getAutorizacao(usuario);
//        String token = "Bearer " + autorizacao.getTokenAcesso();

        return musicService.getSpotify(usuario,categoria);
    }





//    @ResponseStatus(HttpStatus.OK)
//    @RequestMapping(value = "/{nomeCidade}", method = RequestMethod.GET)
//    public Spotify getSpotify(@PathVariable String nomeCidade, @RequestBody Usuario usuario) {
//
//        Temperatura temperatura = temperaturaService.getTemperatura(nomeCidade);
//        String categoria = retornaCategoria(temperatura);
//
//        Autorizacao autorizacao = tokenService.getAutorizacao(usuario);
//        String token = "Bearer " + autorizacao.getTokenAcesso();
//
//        return musicService.getSpotify(usuario,categoria);
//    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{latitude}/{longitude}", method = RequestMethod.GET)
    public Spotify getSpotify(@PathVariable String latitude, @PathVariable String longitude, @RequestBody Usuario usuario) {

        Temperatura temperatura = temperaturaController.getTemperaturaCordenadas(latitude, longitude);
        String categoria = retornaCategoria(temperatura);

//        Autorizacao autorizacao = tokenService.getAutorizacao(usuario);
//        String token = "Bearer " + autorizacao.getTokenAcesso();

        return musicService.getSpotify(usuario,categoria);
    }



    public String retornaCategoria(Temperatura temperatura){

        String categoria = "";

        // If temperature (celcius) is above 30 degrees, suggest tracks for party
        // In case temperature is between 15 and 30 degrees, suggest pop music tracks
        // If it's a bit chilly (between 10 and 14 degrees), suggest rock music tracks
        // Otherwise, if it's freezing outside, suggests classical music tracks

        Double temp = Double.valueOf(temperatura.getMain().getTemp());

          if (temp > 30.0) {
             categoria = "party";
          } else if (temp >= 15.0 && temp <= 30.0) {
              categoria = "pop";
          } else if (temp >= 10.0 && temp <= 14.0) {
              categoria = "rock";
          } else {
              categoria = "classical";
          }

          return categoria;
    }


}
