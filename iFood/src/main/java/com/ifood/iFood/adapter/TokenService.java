package com.ifood.iFood.adapter;

import com.ifood.iFood.models.autorizacao.Autorizacao;
import com.ifood.iFood.models.autorizacao.Usuario;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/token")
public class TokenService {

    @Autowired
    private final TokenClient tokenClient;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.POST)
    public Autorizacao getAutorizacao(@RequestBody Usuario usuario){
        //String credentials = usuario.retornaAuthorization();
        String credentials = "Basic NDlkMjkyYjIwMjk2NDczZTljMWE3MWQ2OTA1ZThhYzY6ZmY4NDkwZTI2MDMwNGMzNGEyYjljNWJhNDAyMTUzZDM=";
        return tokenClient.getAutorizacao(credentials, "application/x-www-form-urlencoded", usuario);
    }

//    @ResponseStatus(HttpStatus.OK)
//    @RequestMapping(method = RequestMethod.POST,
//            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
//    public Autorizacao getAutorizacao(){
//
//        Usuario usuario = new Usuario();
//        //String credentials = usuario.retornaAuthorization();
//        String credentials = "Basic NDlkMjkyYjIwMjk2NDczZTljMWE3MWQ2OTA1ZThhYzY6ZmY4NDkwZTI2MDMwNGMzNGEyYjljNWJhNDAyMTUzZDM=";
//        //String contentType = "application/x-www-form-urlencoded"; = MediaType.APPLICATION_FORM_URLENCODED_VALUE
//        String grantType = "grant_type: client_credentials";
//
//MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
//                map.add("grant_type", "client_credentials");

//        return tokenClient.getAutorizacao(credentials, MediaType.APPLICATION_FORM_URLENCODED_VALUE, grantType);
//        //return tokenClient.getAutorizacao(credentials, MediaType.APPLICATION_FORM_URLENCODED_VALUE, grantType);
//    }

}


