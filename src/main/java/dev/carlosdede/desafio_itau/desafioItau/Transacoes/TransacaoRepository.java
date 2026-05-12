package dev.carlosdede.desafio_itau.desafioItau.Transacoes;

import dev.carlosdede.desafio_itau.desafioItau.Estatistica.EstatisticaDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Repository
public class TransacaoRepository {

    List<TransacaoRequest> listaDeTransacoes = new ArrayList<>();

    //salvar os dados em um lista
    public void salvarDados(TransacaoRequest transacaoRequest){
        log.info("Salvando dados...");
        listaDeTransacoes.add(transacaoRequest);
    }
    //apagar essa lista depois de 60 segundos
    public void limparDados(){

    }

    //apagar todas as transações da lista
    public void deletarDados(){
        log.info("Deletando dados...");
        listaDeTransacoes.clear();

    }

    public EstatisticaDTO estatistica(OffsetDateTime horaInicial){
        if(listaDeTransacoes.isEmpty()){
            log.info("Lista de transações está vazia.");
            return new EstatisticaDTO(0L,0.0,0.0,0.0,0.0);
        }
        log.info("Filtrando lista de transações...");
        final var sumary = listaDeTransacoes.stream()
                .filter(t -> t.getDataHora().isAfter(horaInicial) || t.getDataHora().isEqual(horaInicial))
                .mapToDouble(t -> t.getValor().doubleValue())
                .summaryStatistics();
        return new  EstatisticaDTO(sumary.getCount(), sumary.getAverage(), sumary.getMax(), sumary.getMin(), sumary.getSum());

    }

}
