package staff.Api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import staff.Api.entity.Turma;
import staff.Api.model.InfoPresencaAluno;
import staff.Api.service.TurmaService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/turma")
public class TurmaController {
    private final TurmaService turmaService;

    @GetMapping("/byProfessor")
    public ResponseEntity<?> turmasByProfessorId(@RequestParam String professorId){
        List<Turma> turmas = turmaService.turmasByProfessorId(professorId);

        if (!CollectionUtils.isEmpty(turmas)){
            return ResponseEntity.ok("Turmas localizadas com sucesso: " + turmas);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Turmas não localizadas para o professor com ID " + professorId);
        }
    }

    @GetMapping("/presenca/{turmaId}")
    public List<InfoPresencaAluno> obterPresencaPorTurma(@PathVariable String turmaId) {
        return turmaService.obterPresencaPorTurma(turmaId);
    }
}
