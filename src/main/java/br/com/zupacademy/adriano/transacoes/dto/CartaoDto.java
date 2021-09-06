package br.com.zupacademy.adriano.transacoes.dto;

import br.com.zupacademy.adriano.transacoes.entities.Cartao;

public class CartaoDto {

    private String id;
    private String email;

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public CartaoDto(Cartao cartao) {
        this.id = cartao.getId();
        this.email = cartao.getEmail();
    }
}
