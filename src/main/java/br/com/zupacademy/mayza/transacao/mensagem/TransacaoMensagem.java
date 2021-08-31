package br.com.zupacademy.mayza.transacao.mensagem;

import br.com.zupacademy.mayza.transacao.modelo.Cartao;
import br.com.zupacademy.mayza.transacao.modelo.Estabelecimento;
import br.com.zupacademy.mayza.transacao.modelo.Transacao;
import br.com.zupacademy.mayza.transacao.repositorio.CartaoRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransacaoMensagem {

    private String id;
    private BigDecimal valor;
    private EstabelecimentoMensagem estabelecimento;
    private CartaoMensagem cartao;
    private String efetivadaEm;

    public Transacao toTransacao(CartaoRepository cartaoRepository) {
        Estabelecimento estabelecimento = this.estabelecimento.toEstabelecimento();
        Cartao cartao = this.cartao.toCartao(cartaoRepository);
        return new Transacao(id, valor, estabelecimento, cartao, LocalDateTime.parse(efetivadaEm));
    }

    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public EstabelecimentoMensagem getEstabelecimento() {
        return estabelecimento;
    }

    public CartaoMensagem getCartao() {
        return cartao;
    }

    public String getEfetivadaEm() {
        return efetivadaEm;
    }
}
