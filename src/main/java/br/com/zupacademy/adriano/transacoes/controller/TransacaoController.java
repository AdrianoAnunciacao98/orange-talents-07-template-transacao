package br.com.zupacademy.adriano.transacoes.controller;

import br.com.zupacademy.adriano.transacoes.dto.TransacaoDto;
import br.com.zupacademy.adriano.transacoes.entities.Cartao;
import br.com.zupacademy.adriano.transacoes.entities.Transacao;
import br.com.zupacademy.adriano.transacoes.repository.CartaoRepository;
import br.com.zupacademy.adriano.transacoes.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    @Autowired
    private TransacaoRepository tranrep;

    @Autowired
    private CartaoRepository carrep;

    @GetMapping("/cartoes/{id}")
    public ResponseEntity<List<TransacaoDto>> buscaTransacoes(@PathVariable String id){
        Optional<Cartao> cartaoBanco = carrep.findById(id);
        if(cartaoBanco.isEmpty())
            return ResponseEntity.notFound().build();

        Pageable page = PageRequest.of(0, 10, Sort.Direction.DESC, "efetivadaEm");
        List<Transacao> transacaoList = tranrep.findAllByCartao(cartaoBanco.get(), page);

        return ResponseEntity.ok(TransacaoDto.toResponse(transacaoList));
    }
}
