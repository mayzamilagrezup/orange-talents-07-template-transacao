package br.com.zupacademy.mayza.transacao.mensagem;

import br.com.zupacademy.mayza.transacao.modelo.Estabelecimento;

public class EstabelecimentoMensagem {

    private String nome;
    private String cidade;
    private String endereco;

    public Estabelecimento toEstabelecimento() {
        return new Estabelecimento(nome, cidade, endereco);
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
