package dev.carlosdede.desafio_itau.desafioItau.Estatistica;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.boot.context.properties.ConfigurationProperties;


@Valid
@ConfigurationProperties(prefix = "estatistica")
public record EstatisticaProperties(@Positive @NotNull Integer segundos) {

}
