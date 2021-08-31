package br.com.zupacademy.mayza.transacao.repositorio;

import br.com.zupacademy.mayza.transacao.modelo.Cartao;
import br.com.zupacademy.mayza.transacao.modelo.Transacao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {

    Page<Transacao> findByCartaoOrderByEfetivadaEmDesc(Cartao cartao, Pageable paginacao);
}
