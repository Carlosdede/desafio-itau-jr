package dev.carlosdede.desafio_itau.desafioItau.Transacoes;


import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Slf4j
@Data
@Service
public class TransacaoService {
    private final TransacaoRepository transacaoRepository;

    public TransacaoService (TransacaoRepository transacaoRepository){
        this.transacaoRepository = transacaoRepository;
    }


    public void validarTransacao(TransacaoRequest transacaoRequest){
        log.info("Validando transação...");
        if(transacaoRequest.getValor().compareTo(BigDecimal.ZERO) < 0){
            throw new IllegalArgumentException("Erro: isso não é uma transação valida!");
        }

        if(transacaoRequest.getDataHora().isAfter(OffsetDateTime.now())){
            throw new IllegalArgumentException("Erro: essa não é uma data valida!");
        }

    }
    public void salvar(TransacaoRequest transacaoRequest){
        log.info("Chamando Repository para salvar a transação.");
        transacaoRepository.salvarDados(transacaoRequest);
    }

    public void remover(){
        transacaoRepository.deletarDados();
    }

}
