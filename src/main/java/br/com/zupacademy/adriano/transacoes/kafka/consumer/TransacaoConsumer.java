package br.com.zupacademy.adriano.transacoes.kafka.consumer;

import br.com.zupacademy.adriano.transacoes.entities.Cartao;
import br.com.zupacademy.adriano.transacoes.entities.Transacao;
import br.com.zupacademy.adriano.transacoes.kafka.TransacaoK;
import br.com.zupacademy.adriano.transacoes.repository.CartaoRepository;
import br.com.zupacademy.adriano.transacoes.repository.TransacaoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class TransacaoConsumer {

    @Autowired
    private TransacaoRepository transacaoRepository;

    @Autowired
    private CartaoRepository cartaoRepository;

    private Logger logg;

    public TransacaoConsumer(TransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
        logg = LoggerFactory.getLogger(TransacaoConsumer.class);
    }

    @KafkaListener(topics = "${kafka.consumer.topic}", containerFactory = "transacaoKafkaListenerContainerFactory")
    public void listener(TransacaoK transacaok) {
        Optional<Cartao> cartao = cartaoRepository.findById(transacaok.getIdCard());
        if(cartao.isEmpty())
            cartaoRepository.save(transacaok.getCardTransacao());
        Transacao t = transacaok.toEntity();
        transacaoRepository.save(t);
        logg.info("Processo Concluído.");
    }
}
