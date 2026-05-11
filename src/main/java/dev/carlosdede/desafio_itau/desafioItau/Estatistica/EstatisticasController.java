package dev.carlosdede.desafio_itau.desafioItau.Estatistica;


import dev.carlosdede.desafio_itau.desafioItau.Transacoes.TransacaoRepository;
import lombok.Data;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;

@SpringBootApplication
@ConfigurationPropertiesScan
@Data
@RestController
@RequestMapping("/estatistica")
public class EstatisticasController {

    private final EstatisticaProperties estatisticaProperties;
    private final TransacaoRepository transacaoRepository;
    public EstatisticasController(TransacaoRepository transacaoRepository, EstatisticaProperties estatisticaProperties){
        this.transacaoRepository = transacaoRepository;
        this.estatisticaProperties = estatisticaProperties;

    }

    public ResponseEntity estatistica(){
        final var horaInicial = OffsetDateTime.now().minusSeconds(estatisticaProperties.segundos());
        return ResponseEntity.ok("As estatísticas das transações são: ");
    }

}
