package com.ifood.iFood.models.autorizacao;

import java.util.Base64;

public class Usuario {

    //private String clientId = "49d292b20296473e9c1a71d6905e8ac6";
    //private String senha = "ff8490e260304c34a2b9c5ba402153d3";
    private String grant_type;

    public Usuario() {
    }

//    public String getClientId() {
//        return clientId;
//    }
//
//    public String getSenha() {
//        return senha;
//    }

    public String getGrant_type() {
        return grant_type;
    }

    public void setGrant_type(String grant_type) {
        this.grant_type = grant_type;
    }


//    public String retornaAuthorization(){
//
//        String credenciais = clientId + senha;
//        return "Basic " + Base64.getEncoder().encodeToString(credenciais.getBytes());
//
//    }



}