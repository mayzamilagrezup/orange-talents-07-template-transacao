package br.com.zupacademy.mayza.transacao.kafka;

import br.com.zupacademy.mayza.transacao.mensagem.TransacaoMensagem;
import br.com.zupacademy.mayza.transacao.modelo.Transacao;
import br.com.zupacademy.mayza.transacao.repositorio.CartaoRepository;
import br.com.zupacademy.mayza.transacao.repositorio.TransacaoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ListenerDeTransacao {

    private TransacaoRepository transacaoRepository;
    private CartaoRepository cartaoRepository;
    private final Logger log = LoggerFactory.getLogger(ListenerDeTransacao.class);

    public ListenerDeTransacao(TransacaoRepository transacaoRepository, CartaoRepository cartaoRepository) {
        this.transacaoRepository = transacaoRepository;
        this.cartaoRepository = cartaoRepository;
    }

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void ouvir(TransacaoMensagem transacaoMensagem) {

        Transacao transacao = transacaoMensagem.toTransacao(cartaoRepository);
        transacaoRepository.save(transacao);
        log.info("Transação recebida com sucesso");

    }
}
