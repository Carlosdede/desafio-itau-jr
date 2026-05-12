package dev.carlosdede.desafio_itau.desafioItau.Transacoes;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.OffsetDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Valid
public class TransacaoRequest {

    @Positive
    @NotNull
    private BigDecimal valor;
    private OffsetDateTime dataHora;
}
