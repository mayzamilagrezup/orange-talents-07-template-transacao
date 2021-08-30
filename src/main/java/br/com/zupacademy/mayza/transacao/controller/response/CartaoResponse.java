package br.com.zupacademy.mayza.transacao.controller.response;

import br.com.zupacademy.mayza.transacao.modelo.Cartao;

public class CartaoResponse {

    private String numeroDoCartao;
    private String email;

    public CartaoResponse(Cartao cartao) {
        this.numeroDoCartao = cartao.getIdApi();
        this.email = cartao.getEmail();
    }

    public String getNumeroDoCartao() {
        return numeroDoCartao;
    }

    public String getEmail() {
        return email;
    }
}
