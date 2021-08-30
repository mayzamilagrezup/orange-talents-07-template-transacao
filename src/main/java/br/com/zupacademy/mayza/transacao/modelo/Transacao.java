package br.com.zupacademy.mayza.transacao.modelo;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String idApi;
    private BigDecimal valor;

    @Embedded
    private Estabelecimento estabelecimento;

    @ManyToOne(cascade=CascadeType.PERSIST)
    private Cartao cartao;
    private LocalDateTime efetivadaEm;

    public Transacao(String idApi, BigDecimal valor, Estabelecimento estabelecimento, Cartao cartao, LocalDateTime efetivadaEm) {
        this.idApi = idApi;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
        this.efetivadaEm = efetivadaEm;
    }

    private Transacao() {
    }

    public Long getId() {
        return id;
    }

    public String getIdApi() {
        return idApi;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }
}
