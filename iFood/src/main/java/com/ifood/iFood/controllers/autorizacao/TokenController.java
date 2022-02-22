package com.ifood.iFood.controllers.autorizacao;

import com.ifood.iFood.client.TokenClient;
import com.ifood.iFood.models.autorizacao.Autorizacao;
import com.ifood.iFood.models.autorizacao.Usuario;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;

@RestController
@AllArgsConstructor
@RequestMapping("/token")
public class TokenController {

    @Autowired
    private final TokenClient tokenClient;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.POST)
    public Autorizacao getAutorizacao(@RequestBody Usuario usuario){

        String credentials = usuario.getClient_id() + ":" +  usuario.getPassword();
        String credentialsBase64 = "Basic " + Base64.getEncoder().encodeToString(credentials.getBytes());

        return tokenClient.getAutorizacao(credentialsBase64, MediaType.APPLICATION_FORM_URLENCODED_VALUE, usuario);
    }





//    @ResponseStatus(HttpStatus.OK)
//    @RequestMapping(method = RequestMethod.POST)
//    public Autorizacao getAutorizacao(@RequestBody Usuario usuario){
//
//        String identificacao = usuario.getClient_id() + ":" +  usuario.getPassword();
//        String credentials = "Basic " + Base64.getEncoder().encodeToString(identificacao.getBytes());
//
//        //String credentials = usuario.retornaAuthorization();
//        //String credentials = "Basic NDlkMjkyYjIwMjk2NDczZTljMWE3MWQ2OTA1ZThhYzY6ZmY4NDkwZTI2MDMwNGMzNGEyYjljNWJhNDAyMTUzZDM=";
//        return tokenClient.getAutorizacao(credentials, MediaType.APPLICATION_FORM_URLENCODED_VALUE, usuario);
//    }




}


