package br.com.zupacademy.mayza.transacao.mensagem;

import br.com.zupacademy.mayza.transacao.modelo.Cartao;

public class CartaoMensagem {

    private String id;
    private String email;

    public Cartao toCartao() {
        return new Cartao(id, email);
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}
