package com.ifood.iFood.adapter;

import com.ifood.iFood.models.Temperatura;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value="temperatura", url = "https://api.openweathermap.org/data/2.5/weather/")
public interface TemperaturaClient {

    @GetMapping(value = "?q={nomeCidade}&appid=b77e07f479efe92156376a8b07640ced&units=metric")
    Temperatura getTemperatura(@PathVariable("nomeCidade")String nomeCidade);

    @GetMapping(value = "?lat={latitude}&lon={longitude}&appid=b77e07f479efe92156376a8b07640ced&units=metric")
    Temperatura getTemperaturaCordenadas(@PathVariable("latitude")String latitude, @PathVariable("longitude")String longitude);


}

