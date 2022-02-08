package com.ifood.iFood.models.autorizacao;

import com.fasterxml.jackson.annotation.JsonAlias;

public class Autorizacao {

    private Usuario usuario;

    @JsonAlias("access_token")
    private String tokenAcesso;

    @JsonAlias("token_type")
    private String tokenType;

    @JsonAlias("expires_in")
    private Integer timeout;

    public String getTokenAcesso() {
        return tokenAcesso;
    }

    public void setTokenAcesso(String tokenAcesso) {
        this.tokenAcesso = tokenAcesso;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public Integer getTimeout() {
        return timeout;
    }

    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }
}
