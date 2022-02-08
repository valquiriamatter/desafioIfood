//package com.ifood.iFood.services;
//
//import com.ifood.iFood.models.Temperatura;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Service;
//import org.springframework.web.reactive.function.client.WebClient;
//import reactor.core.publisher.Mono;
//
//import static org.springframework.http.MediaType.APPLICATION_JSON;
//
//@Service
//public class TemperaturaServiceWebflux {
//
//    private final WebClient webClient;
//    static String url = "https://api.openweathermap.org/data/2.5/weather";
//    static String apiKey = "b77e07f479efe92156376a8b07640ced";
//    static String celsius  = "&units=metric";
//
//    public TemperaturaServiceWebflux(WebClient.Builder builder) {
//        this.webClient = builder.baseUrl(url).build();
//    }
//
//    public Temperatura obterTemperaturaCidade(String nomeCidade) {
//
//        String urlChamada = url + "?q=" + nomeCidade + "&appid=" + apiKey + celsius;
//
//        return this.webClient
//                .get()
//                .uri(urlChamada)
//                .accept(APPLICATION_JSON)
//                .retrieve()
//                .onStatus(HttpStatus::is4xxClientError, error -> Mono.error(new RuntimeException("Verifique o nome da cidade.")))
//                .bodyToMono(Temperatura.class)
//                .block();
//
//    }
//
//    public Mono<Temperatura> obterTemperaturaPorCordenadas(String latitude, String longitude) {
//
//        String urlChamada = url + "?" + "lat=" + latitude + "&lon=" + longitude + "&appid=" + apiKey + celsius;
//
//        return this.webClient
//                .get()
//                .uri(urlChamada)
//                .accept(APPLICATION_JSON)
//                .retrieve()
//                .onStatus(HttpStatus::is4xxClientError, error -> Mono.error(new RuntimeException("Verifique as cordenadas enviadas.")))
//                .bodyToMono(Temperatura.class);
//
//    }
//
//    public Mono<Temperatura> obterTemperaturaPorCidade(String nomeCidade) {
//
//        String urlChamada = url + "?q=" + nomeCidade + "&appid=" + apiKey + celsius;
//
//        return this.webClient
//                .get()
//                .uri(urlChamada)
//                .accept(APPLICATION_JSON)
//                .retrieve()
//                .onStatus(HttpStatus::is4xxClientError, error -> Mono.error(new RuntimeException("Verifique o nome da cidade.")))
//                .bodyToMono(Temperatura.class);
//
//    }
//
////    If temperature (celcius) is above 30 degrees, suggest tracks for party
////    In case temperature is between 15 and 30 degrees, suggest pop music tracks
////    If it's a bit chilly (between 10 and 14 degrees), suggest rock music tracks
////    Otherwise, if it's freezing outside, suggests classical music tracks
//
//      public void verificaTemperatura(Temperatura temperatura) {
//
//          Double temp = Double.valueOf(temperatura.getMain().getTemp());
//
//          if (temp > 30.0) {
//              System.out.println("tracks for party");
//          } else if (temp >= 15.0 && temp <= 30.0) {
//              System.out.println("pop music tracks");
//          } else if (temp >= 10.0 && temp <= 14.0) {
//              System.out.println("pop music tracks");
//          } else {
//              System.out.println("classical music tracks");
//          }
//
//
//      }
//
//}
