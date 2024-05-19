package staff.Api.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import staff.Api.entity.Professor;
import staff.Api.request.LoginRequest;
import staff.Api.request.ProfessorRequest;
import staff.Api.service.ProfessorService;

import java.util.List;


@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/professor")
public class ProfessorController {
    private final ProfessorService professorService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        Professor professor = professorService.login(loginRequest.getLogin(), loginRequest.getSenha());
        log.info(String.valueOf(professor));

        if (professor != null) {
            return ResponseEntity.ok(professor); // Retorna o Professor encontrado
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login ou senha incorretos.");
        }
    }

    @GetMapping("/getAll")
    public List<Professor> getAllProfessores() {
        return professorService.getAll();
    }

    @PostMapping("/addProfessor")
    public ResponseEntity<String> addProfessor(@RequestBody ProfessorRequest professorRequest) {
        Professor professor = professorService.addProfessor(professorRequest);
        if (professor != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Professor adicionado com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Falha ao adicionar o professor.");
        }
    }
}
