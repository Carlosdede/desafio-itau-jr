package dev.carlosdede.desafio_itau.desafioItau.Docs;


import dev.carlosdede.desafio_itau.desafioItau.Transacoes.TransacaoRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;


@Tag(name="Transações", description = "Endpoints responsáveis por criar e adicionar as transações em uma lista")
public interface TransacaoControllerDoc {


    @Operation(summary = "Cria transação", description = "Recebe uma transação valida e adiciona em uma lista")

    @ApiResponse(responseCode = "201", description = "Transação criada com sucesso")
    ResponseEntity<Void> adicionar(@RequestBody TransacaoRequest transacaoRequest);


    @Operation(summary = "Deleta transação", description = "Remove todas transações da lista")
    @ApiResponse(responseCode = "200", description = "Todas as transações foram deletadas")
    ResponseEntity<Void> remover();

}
