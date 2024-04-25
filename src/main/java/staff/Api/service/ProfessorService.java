package staff.Api.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import staff.Api.entity.Professor;
import staff.Api.mapper.ProfessorMapper;
import staff.Api.repository.ProfessorRepository;
import staff.Api.request.ProfessorRequest;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProfessorService {
    private final  ProfessorRepository professorRepository;

    public Professor add(ProfessorRequest request){
        return professorRepository.save(ProfessorMapper.toProfessor(request));
    }

    public Professor login(String login, String senha) {
        log.info("Tentativa de login com login: {}, senha: {}", login, senha);
        Professor professor = professorRepository.findByLoginAndSenha(login, senha);
        log.info("Professor encontrado: {}", professor);
        return professor;
    }

    public List<Professor> getAll() {
        return professorRepository.findAll();
    }

    public Professor addProfessor(ProfessorRequest professorRequest) {
        Professor professor = ProfessorMapper.toProfessor(professorRequest);
        return professorRepository.save(professor);
    }
}
