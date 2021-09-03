package br.com.zupacademy.adriano.transacoes.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String idApi;

    @NotNull
    private Double valor;

    @NotNull
    @Embedded
    private Estabelecimento estabelecimento;

    @NotNull
    @ManyToOne
    private Cartao cartao;

    @NotNull
    private LocalDateTime efetivadaEm;

    private Transacao() {}

    public Transacao(String idApi, Double valor, Estabelecimento estabelecimento, Cartao cartao, LocalDateTime efetivadaEm) {
        this.idApi = idApi;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
        this.efetivadaEm = efetivadaEm;
    }

    public Double getValor() {
        return valor;
    }

    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }
}
