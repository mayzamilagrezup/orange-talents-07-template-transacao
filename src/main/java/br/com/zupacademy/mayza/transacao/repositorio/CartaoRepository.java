package br.com.zupacademy.mayza.transacao.repositorio;

import br.com.zupacademy.mayza.transacao.modelo.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartaoRepository extends JpaRepository<Cartao, Long> {
}
