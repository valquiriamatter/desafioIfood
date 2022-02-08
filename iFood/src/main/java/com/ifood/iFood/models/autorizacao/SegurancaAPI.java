package com.ifood.iFood.models.autorizacao;

public class SegurancaAPI {

    private Autorizacao autorizacao;
    private Usuario usuario;

    public SegurancaAPI() {
    }

    public Autorizacao getAutorizacao() {
        return autorizacao;
    }

    public void setAutorizacao(Autorizacao autorizacao) {
        this.autorizacao = autorizacao;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

//    public void atualizarToken(String token, Date expiracaoToken) {
//
//        Usuario usuario = new Usuario();
//
//        this.autorizacao.setTokenType(token);
//        this.autorizacao.setTokenAcesso(expiracaoToken);
//    }

//    public void expirarToken() {
//        this.atualizarToken("", new Date());
//    }
//
//    public boolean expirado() {
//        return expiracaoToken != null && expiracaoToken.before(new Date());
//    }
//
//    public String getToken() {
//        if (StringUtils.isBlank(token)) {
//            return null;
//        }
//        return token;
//    }

}
