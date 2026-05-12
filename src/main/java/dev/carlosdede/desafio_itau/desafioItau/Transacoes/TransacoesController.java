package dev.carlosdede.desafio_itau.desafioItau.Transacoes;


import dev.carlosdede.desafio_itau.desafioItau.Docs.TransacaoControllerDoc;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transacao")


public class TransacoesController implements TransacaoControllerDoc {

    private final TransacaoService transacaoService;


    public TransacoesController(TransacaoService transacaoService){
        this.transacaoService = transacaoService;

    }

    @PostMapping
    @Operation (summary = "Cria transação",
    description = "Recebe uma transação valida e adiciona em uma lista")
    public ResponseEntity adicionar(@RequestBody TransacaoRequest transacaoRequest) {
        try {
            transacaoService.validarTransacao(transacaoRequest);
            transacaoService.salvar(transacaoRequest);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (IllegalArgumentException exception) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping
    public ResponseEntity remover(){
        try{
            transacaoService.remover();
            return ResponseEntity.ok("Transação removida!");
        } catch (Exception e) {
            throw new RuntimeException(e+"Não foi possível deletar a transação!");
        }

    }
}
