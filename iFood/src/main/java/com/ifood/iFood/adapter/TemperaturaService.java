package com.ifood.iFood.adapter;

import com.ifood.iFood.models.Temperatura;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/temperatura")
public class TemperaturaService {

    private final TemperaturaClient temperaturaClient;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{nomeCidade}", method = RequestMethod.GET)
    public Temperatura getTemperatura(@PathVariable String nomeCidade) {
        return temperaturaClient.getTemperatura(nomeCidade);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{latitude}/{longitude}", method = RequestMethod.GET)
    public Temperatura getTemperaturaCordenadas(@PathVariable String latitude, @PathVariable String longitude) {
        return temperaturaClient.getTemperaturaCordenadas(latitude, longitude);
    }
}


