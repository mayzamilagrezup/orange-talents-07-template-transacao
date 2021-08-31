package br.com.zupacademy.mayza.transacao.repositorio;

import br.com.zupacademy.mayza.transacao.modelo.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartaoRepository extends JpaRepository<Cartao, Long> {

    Optional<Cartao> findByIdApi(String idApi);
}
