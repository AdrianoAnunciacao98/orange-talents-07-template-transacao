package br.com.zupacademy.adriano.transacoes.kafka;

import br.com.zupacademy.adriano.transacoes.entities.Cartao;

public class CartaoK {

    private String id;
    private String email;

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public Cartao toEntity() {
        return new Cartao(id, email);
} }
