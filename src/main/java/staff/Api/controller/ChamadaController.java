package staff.Api.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import staff.Api.entity.Chamada;
import staff.Api.request.ChamadaRequest;
import staff.Api.service.ChamadaService;

@RestController
@RequestMapping("/chamadas")
@AllArgsConstructor
public class ChamadaController {
    private final ChamadaService chamadaService;

    @PostMapping("/criar")
    public ResponseEntity<String> criarChamada(@RequestBody ChamadaRequest chamadaRequest) {
        chamadaService.registrarChamada(chamadaRequest);
        return ResponseEntity.ok("Chamada criada com sucesso.");
    }

    @GetMapping("/{chamadaId}")
    public ResponseEntity<?> getChamadaDetails(@PathVariable String chamadaId) {
        Chamada chamada = chamadaService.chamadaById(chamadaId);
        if (chamada != null) {
            return ResponseEntity.ok(chamada);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Chamada não encontrada com o ID: " + chamadaId);
        }
    }
}
