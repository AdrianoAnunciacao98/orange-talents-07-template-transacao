package br.com.zupacademy.adriano.transacoes.kafka;

import br.com.zupacademy.adriano.transacoes.entities.Estabelecimento;

public class EstabelecimentoK {

    private String nome;
    private String cidade;
    private String endereco;

    public String getNome() {
        return nome;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public Estabelecimento toEntity() {
        return new Estabelecimento(nome, cidade, endereco);
    }
}
