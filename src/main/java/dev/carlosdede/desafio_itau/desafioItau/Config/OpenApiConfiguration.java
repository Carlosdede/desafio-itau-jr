package dev.carlosdede.desafio_itau.desafioItau.Config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {
    @Bean
    public OpenAPI openAPI(){
        return new OpenAPI()
                .info(
                        new Info()
                                .title("Api desafio ITAU")
                                .description("Api desafio técnico do Itau")
                                .version("1.0.0")
                );

    }
}
