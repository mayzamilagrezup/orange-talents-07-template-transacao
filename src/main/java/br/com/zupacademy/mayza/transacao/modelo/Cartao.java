package br.com.zupacademy.mayza.transacao.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cartao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String idApi;
    private String email;

    public Cartao(String idApi, String email) {
        this.idApi = idApi;
        this.email = email;
    }

    private Cartao() {
    }

    public Long getId() {
        return id;
    }

    public String getIdApi() {
        return idApi;
    }

    public String getEmail() {
        return email;
    }
}
