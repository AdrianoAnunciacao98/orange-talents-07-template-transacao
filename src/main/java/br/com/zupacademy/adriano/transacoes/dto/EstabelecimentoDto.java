package br.com.zupacademy.adriano.transacoes.dto;

import br.com.zupacademy.adriano.transacoes.entities.Estabelecimento;

public class EstabelecimentoDto {

    private String nome;
    private String cidade;
    private String endereco;

    public EstabelecimentoDto(Estabelecimento estabelecimento) {
        this.nome = estabelecimento.getNome();
        this.cidade = estabelecimento.getCidade();
        this.endereco = estabelecimento.getEndereco();
    }

    public String getNome() {
        return nome;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEndereco() {
        return endereco;
    }
}
