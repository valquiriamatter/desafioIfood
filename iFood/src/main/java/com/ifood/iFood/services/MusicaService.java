package com.ifood.iFood.services;

import com.ifood.iFood.models.autorizacao.Autorizacao;
import com.ifood.iFood.models.Spotify;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Base64;


@Service
public class MusicaService {

    private final WebClient webClient;

    static String url = "https://api.spotify.com";
    static String clientId = "49d292b20296473e9c1a71d6905e8ac6";
    static String clientSecret = "ff8490e260304c34a2b9c5ba402153d3";
    static String redirectUri = "http://localhost:8080/callback";

    public MusicaService(WebClient.Builder builder) {
        this.webClient = builder.baseUrl(url).build();
    }

    public Mono<Autorizacao> recuperaToken() {

        String uri = "https://accounts.spotify.com/api/token";

        String credentials = clientId + ":" + clientSecret;
        String encodedCredentials = Base64.getEncoder().encodeToString(credentials.getBytes());

        MultiValueMap<String,String> bodyValues = new LinkedMultiValueMap<>();
        bodyValues.add("grant_type", "client_credentials");

        //NDlkMjkyYjIwMjk2NDczZTljMWE3MWQ2OTA1ZThhYzY6ZmY4NDkwZTI2MDMwNGMzNGEyYjljNWJhNDAyMTUzZDM=

        return this.webClient
                .post()
                .uri(uri)
                .header("Authorization", "Basic " + encodedCredentials)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .accept(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromFormData(bodyValues))
                .retrieve()
                .bodyToMono(Autorizacao.class);

    }

    public Mono<Spotify> recuperaLista(String categoria) {

        Mono<Spotify> lista;

        String uri = "https://api.spotify.com/v1/browse/categories/";
        String token = "BQAwQAH0UWqvgaxsWF5I1Scs_F3gCcYhrzPnHIja2tHMR5Ab_KEh_J689cKCNszHfKH_KQczBfml23JzE4A";

        lista = this.webClient
                .get()
                .uri(uri + categoria + "/playlists")
                .header("Authorization", "Barer " + token)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Spotify.class);

        return lista;
    }

    public Flux<Spotify> listaNomeMusicas(String categoria) {

        String uri = "https://api.spotify.com/v1/browse/categories/";
        String token = "BQAcUR0gPOZ8ZApJKbVvzV0X6U6XScDkQKIFnCh8RAqZK_gHX1JCGMf7IBudlla4f895TIjjQLanu5QSGeo";

//        Gson gson = new Gson();
//        ListaDeMusicas listaDeMusicas = gson.fromJson(String.valueOf(listaNomeMusicas(categoria)), ListaDeMusicas.class);

        Flux<Spotify> musicaSource = webClient
                .get()
                .uri(uri + categoria + "/playlists")
                .header("Authorization", "Barer " + token)
                //.accept(MediaType.APPLICATION_JSON)
                //.retrieve()
                .exchange()
                        .flatMapMany(listaNomeMusicas -> listaNomeMusicas.bodyToFlux(Spotify.class));
                //.onStatus(HttpStatus::is4xxClientError,
                //        error -> Mono.error(new RuntimeException("verifique os parâmetros informados")))
                //.bodyToFlux(ListaDeMusicas.class)
                //.doOnNext(System.out::println);

        //musicaSource.blockLast();

        return musicaSource;

    }




//    public List<String> listaMusicas(String categoria){
//
//        String uri = "https://api.spotify.com/v1/browse/categories/";
//        String token = "BQBAy-58OC5vxHv62uQq_pzM4q8b7zzm5065fEKiUrrjaJqZ_tPSnCMi-ph5TNLDMLjluTa4HIbKL0TxcDY";
//        //String token = recuperaToken().block().getTokenAcesso();
//
//        Mono<List<ListaDeMusicas>> response = this.webClient
//                .get()
//                .uri(uri + categoria + "/playlists")
//                .header("Authorization", "Barer " + token)
//                .accept(MediaType.APPLICATION_JSON)
//                .retrieve()
//                .bodyToMono(new ParameterizedTypeReference<List<ListaDeMusicas>>() {});
//
//            List<ListaDeMusicas> listaDeMusicas = response.block();
//
//            return listaDeMusicas.stream()
//                    .map(ListaDeMusicas::getName)
//                    .collect(Collectors.toList());
//
//    }

//    public List<String> listaMusicas(String categoria){
//
//        String uri = "https://api.spotify.com/v1/browse/categories/";
//        String token = "BQBAy-58OC5vxHv62uQq_pzM4q8b7zzm5065fEKiUrrjaJqZ_tPSnCMi-ph5TNLDMLjluTa4HIbKL0TxcDY";
//        //String token = recuperaToken().block().getTokenAcesso();
//
//        Flux<Musica> response = this.webClient
//                .get()
//                .uri(uri + categoria + "/playlists")
//                .header("Authorization", "Barer " + token)
//                .accept(MediaType.APPLICATION_JSON)
//                .retrieve()
//                .bodyToFlux(Musica.class)
//                .doOnNext(System.out::println);
//
//
//        Musica musica =  response.blockFirst();
//
//        return musicas.stream()
//                .map(Musica::getName)
//                .collect(Collectors.toList());
//
//
//    }





}
