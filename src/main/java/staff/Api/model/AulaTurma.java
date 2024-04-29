package staff.Api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AulaTurma {
    private String horairo;
    private String materia;
    private String nomeProfessor;
    private String professorId;
}
