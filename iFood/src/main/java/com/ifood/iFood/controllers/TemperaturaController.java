package com.ifood.iFood.controllers;

import com.ifood.iFood.models.Temperatura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import com.ifood.iFood.services.TemperaturaService;

@RestController
@RequestMapping("/temp")
public class TemperaturaController {

        @Autowired
        private TemperaturaService temperaturaService;

//        @GetMapping("/{nomeCidade}")
//        public ResponseEntity<Mono<Temperatura>> consultaTemperaturaPorCidade(@PathVariable String nomeCidade) {
//
//            Mono<Temperatura> temperatura = temperaturaService.obterTemperaturaPorCidade(nomeCidade);
//            return ResponseEntity.ok(temperatura);
//        }

        @GetMapping("/{latitude}/{longitude}")
        public ResponseEntity<Mono<Temperatura>> consultaTemperaturaPoCordenadas(@PathVariable String latitude, @PathVariable String longitude) {

        Mono<Temperatura> temperatura = temperaturaService.obterTemperaturaPorCordenadas(latitude,longitude);
        return ResponseEntity.ok(temperatura);
    }

    @GetMapping("/{nomeCidade}")
    public ResponseEntity<Temperatura> consultaTemperaturaCidade(@PathVariable String nomeCidade) {

        Temperatura temperatura = temperaturaService.obterTemperaturaCidade(nomeCidade);
        temperaturaService.verificaTemperatura(temperatura);
        return ResponseEntity.ok(temperatura);
    }



}
