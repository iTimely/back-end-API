package staff.Api.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import staff.Api.dto.AlunoRelatorioDto;
import staff.Api.service.TurmaService;

import java.io.ByteArrayOutputStream;
import java.io.IOException;


import java.io.IOException;
import java.util.List;

@Controller
public class RelatorioController {
    @Autowired
    private TurmaService turmaService;

    @GetMapping("/relatorio/turma")
    public ResponseEntity<List<AlunoRelatorioDto>> getRelatorioTurma(@RequestParam String turmaId) {
        List<AlunoRelatorioDto> relatorio = turmaService.getRelatorioTurma(turmaId);
        return ResponseEntity.ok(relatorio);
    }
}
