package br.com.zupacademy.mayza.transacao.modelo;

import javax.persistence.Embeddable;

@Embeddable
public class Estabelecimento {

    private String nome;
    private String cidade;
    private String endereco;

    public Estabelecimento(String nome, String cidade, String endereco) {
        this.nome = nome;
        this.cidade = cidade;
        this.endereco = endereco;
    }

    private Estabelecimento() {
    }

    public String getNome() {
        return nome;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEndereco() {
        return endereco;
    }
}
