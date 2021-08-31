package br.com.zupacademy.mayza.transacao.controller;

import br.com.zupacademy.mayza.transacao.controller.response.TransacaoResponse;
import br.com.zupacademy.mayza.transacao.modelo.Cartao;
import br.com.zupacademy.mayza.transacao.modelo.Transacao;
import br.com.zupacademy.mayza.transacao.repositorio.CartaoRepository;
import br.com.zupacademy.mayza.transacao.repositorio.TransacaoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/cartoes")
public class ConsultarComprasController {

    private TransacaoRepository transacaoRepository;
    private CartaoRepository cartaoRepository;
    private final Logger log = LoggerFactory.getLogger(ConsultarComprasController.class);

    public ConsultarComprasController(TransacaoRepository transacaoRepository, CartaoRepository cartaoRepository) {
        this.transacaoRepository = transacaoRepository;
        this.cartaoRepository = cartaoRepository;
    }

    @GetMapping("/{id}/transacoes")
    public ResponseEntity<Page<TransacaoResponse>> consultar(@PathVariable Long id,
                                                             @PageableDefault(page = 0, size = 10) Pageable paginacao) {

        Optional<Cartao> cartaoOptional = cartaoRepository.findById(id);
        if (cartaoOptional.isEmpty()) {
            log.error("O cartão de id {} não foi encontrado", id);
            return ResponseEntity.notFound().build();
        }

        Cartao cartao = cartaoOptional.get();

        Page<Transacao> transacoes = transacaoRepository.findByCartaoOrderByEfetivadaEmDesc(cartao, paginacao);
        Page<TransacaoResponse> lista = TransacaoResponse.converter(transacoes);
        log.info("Consulta realizada com sucesso! Cartão {}", cartao.getIdApi());

        return ResponseEntity.ok(lista);

    }
}
