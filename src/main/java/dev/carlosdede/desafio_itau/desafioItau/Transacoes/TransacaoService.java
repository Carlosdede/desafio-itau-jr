package dev.carlosdede.desafio_itau.desafioItau.Transacoes;


import lombok.Data;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
@Service
public class TransacaoService {
    private final TransacaoRepository transacaoRepository;

    public TransacaoService (TransacaoRepository transacaoRepository){
        this.transacaoRepository = transacaoRepository;
    }


    public void validarTransacao(TransacaoRequest transacaoRequest){
        if(transacaoRequest.getValor().compareTo(BigDecimal.ZERO) < 0){
            throw new IllegalArgumentException("Erro: isso não é uma transação valida!");
        }

        if(transacaoRequest.getDataHora().isAfter(OffsetDateTime.now())){
            throw new IllegalArgumentException("Erro: essa não é uma data valida!");
        }

    }
    public void salvar(TransacaoRequest transacaoRequest){
        transacaoRepository.salvarDados(transacaoRequest);
    }

    public void remover(){
        transacaoRepository.deletarDados();
    }

}
