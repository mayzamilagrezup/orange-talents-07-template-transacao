package br.com.zupacademy.mayza.transacao.mensagem;

import br.com.zupacademy.mayza.transacao.modelo.Cartao;
import br.com.zupacademy.mayza.transacao.repositorio.CartaoRepository;

import java.util.Optional;

public class CartaoMensagem {

    private String id;
    private String email;

    public Cartao toCartao(CartaoRepository cartaoRepository) {
        Optional<Cartao> optionalCartao = cartaoRepository.findByIdApi(this.id);
        if (optionalCartao.isPresent()) {
            return optionalCartao.get();
        }
        Cartao cartao = new Cartao(id, email);
        cartaoRepository.save(cartao);
        return cartao;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}
