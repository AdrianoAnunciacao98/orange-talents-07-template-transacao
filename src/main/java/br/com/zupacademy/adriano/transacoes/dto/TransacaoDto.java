package br.com.zupacademy.adriano.transacoes.dto;

import br.com.zupacademy.adriano.transacoes.entities.Transacao;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TransacaoDto {

    private Double valor;
    private EstabelecimentoDto estabelecimento;
    private CartaoDto cartao;
    private LocalDateTime efetivadaEm;

    public TransacaoDto(Transacao transacao){
        this.valor = transacao.getValor();
        this.efetivadaEm = transacao.getEfetivadaEm();
        this.cartao = new CartaoDto(transacao.getCartao());
        this.estabelecimento = new EstabelecimentoDto((transacao.getEstabelecimento()));
    }

    public static List<TransacaoDto> toResponse(List<Transacao> transacoesBanco) {
        List<TransacaoDto> listaTransacoes = new ArrayList<>();
        transacoesBanco.forEach(t -> listaTransacoes.add(new TransacaoDto(t)));

        return listaTransacoes;
    }

    public Double getValor() {
        return valor;
    }

    public EstabelecimentoDto getEstabelecimento() {
        return estabelecimento;
    }

    public CartaoDto getCartao() {
        return cartao;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }
}
