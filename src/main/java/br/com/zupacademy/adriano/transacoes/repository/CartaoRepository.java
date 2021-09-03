package br.com.zupacademy.adriano.transacoes.repository;

import br.com.zupacademy.adriano.transacoes.entities.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartaoRepository extends JpaRepository<Cartao, String> {
}
