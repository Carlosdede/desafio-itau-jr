package dev.carlosdede.desafio_itau.desafioItau.Docs;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name = "Estatísticas", description = "Endpoint responsável pos listar as estatísticas.")
public interface EstatisticaControllerDoc {

    @Operation(summary = "Mostrar estatísticas", description = "Mostra detalhadamente estatísticas da transação.")
    @ApiResponse(responseCode = "200", description = "Estatísticas listadas com sucesso!")
    ResponseEntity<Void> estatistica();
}
