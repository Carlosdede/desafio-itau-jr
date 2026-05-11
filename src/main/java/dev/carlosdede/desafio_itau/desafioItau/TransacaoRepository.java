package dev.carlosdede.desafio_itau.desafioItau;

import org.springframework.stereotype.Repository;

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

}
