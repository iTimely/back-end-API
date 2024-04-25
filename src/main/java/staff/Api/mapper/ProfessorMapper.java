package staff.Api.mapper;

import staff.Api.entity.Professor;
import staff.Api.request.ProfessorRequest;


public class ProfessorMapper {

    public static Professor toProfessor(ProfessorRequest request){
        return Professor.builder()
                .nomeCompleto(request.getNomeCompleto())
                .idade(request.getIdade())
                .materia(request.getMateria())
                .turmas(request.getTurmas())
                .login(request.getLogin())
                .senha(request.getSenha())
                .telefone(request.getTelefone())
                .email(request.getEmail())
                .build();
    }
}