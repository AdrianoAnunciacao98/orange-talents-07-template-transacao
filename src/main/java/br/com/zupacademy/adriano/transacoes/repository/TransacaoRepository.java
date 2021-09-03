package br.com.zupacademy.adriano.transacoes.repository;

import br.com.zupacademy.adriano.transacoes.entities.Transacao;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransacaoRepository extends PagingAndSortingRepository<Transacao, String> {
}
