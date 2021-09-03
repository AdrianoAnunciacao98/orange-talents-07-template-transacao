package br.com.zupacademy.adriano.transacoes.kafka;

import br.com.zupacademy.adriano.transacoes.entities.Cartao;
import br.com.zupacademy.adriano.transacoes.entities.Estabelecimento;
import br.com.zupacademy.adriano.transacoes.entities.Transacao;

import java.time.LocalDateTime;

public class TransacaoK {

    private String id;
    private Double valor;
    private EstabelecimentoK estabelecimento;
    private CartaoK cartao;
    private LocalDateTime efetivadaEm;

    public String getId() {
        return id;
    }

    public Double getValor() {
        return valor;
    }

    public EstabelecimentoK getEstabelecimento() {
        return estabelecimento;
    }

    public CartaoK getCartao() {
        return cartao;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

    public Cartao getCardTransacao(){
        return cartao.toEntity();
    }

    public String getIdCard(){
        return cartao.getId();
    }

    public Transacao toEntity() {
        Cartao cartao = this.cartao.toEntity();
        Estabelecimento estabelecimento = this.estabelecimento.toEntity();

        return new Transacao(id, valor, estabelecimento, cartao, efetivadaEm);
    }
}
