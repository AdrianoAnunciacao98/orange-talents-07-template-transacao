package br.com.zupacademy.adriano.transacoes.repository;

import br.com.zupacademy.adriano.transacoes.entities.Cartao;
import br.com.zupacademy.adriano.transacoes.entities.Transacao;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface TransacaoRepository extends PagingAndSortingRepository<Transacao, String> {

    List<Transacao> findAllByCartao(Cartao cartao, Pageable pageable);
}
