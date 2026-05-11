package dev.carlosdede.desafio_itau.desafioItau.Estatistica;

import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties(prefix = "estatistica")
public record EstatisticaProperties(Integer segundos) {

}
