package dev.carlosdede.desafio_itau.desafioItau.Estatistica;


import dev.carlosdede.desafio_itau.desafioItau.Docs.EstatisticaControllerDoc;
import dev.carlosdede.desafio_itau.desafioItau.Transacoes.TransacaoRepository;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;

@Slf4j
@SpringBootApplication
@ConfigurationPropertiesScan
@Data
@RestController
@RequestMapping("/estatistica")
public class EstatisticasController implements EstatisticaControllerDoc {

    private final EstatisticaProperties estatisticaProperties;
    private final TransacaoRepository transacaoRepository;
    public EstatisticasController(TransacaoRepository transacaoRepository, EstatisticaProperties estatisticaProperties){
        this.transacaoRepository = transacaoRepository;
        this.estatisticaProperties = estatisticaProperties;

    }

    @GetMapping
    public ResponseEntity estatistica(){
        final var horaInicial = OffsetDateTime.now().minusSeconds(estatisticaProperties.segundos());
        log.info("Retornando estatísticas");
        return ResponseEntity.ok(transacaoRepository.estatistica(horaInicial));
    }

}
