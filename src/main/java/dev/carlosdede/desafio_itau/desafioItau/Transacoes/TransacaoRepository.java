package dev.carlosdede.desafio_itau.desafioItau.Transacoes;

import dev.carlosdede.desafio_itau.desafioItau.Estatistica.EstatisticaDTO;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TransacaoRepository {

    List<TransacaoRequest> listaDeTransacoes = new ArrayList<>();

    //salvar os dados em um lista
    public void salvarDados(TransacaoRequest transacaoRequest){
        listaDeTransacoes.add(transacaoRequest);
    }
    //apagar essa lista depois de 60 segundos
    public void limparDados(){

    }

    //apagar todas as transações da lista
    public void deletarDados(){
        listaDeTransacoes.clear();

    }

    public EstatisticaDTO estatistica(OffsetDateTime horaInicial){
        if(listaDeTransacoes.isEmpty()){
            return new EstatisticaDTO(0L,0.0,0.0,0.0,0.0);
        }
        final var sumary = listaDeTransacoes.stream()
                .filter(t -> t.getDataHora().isAfter(horaInicial) || t.getDataHora().isEqual(horaInicial))
                .mapToDouble(t -> t.getValor().doubleValue())
                .summaryStatistics();
        return new  EstatisticaDTO(sumary.getCount(), sumary.getAverage(), sumary.getMax(), sumary.getMin(), sumary.getSum());

    }

}
