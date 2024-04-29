package staff.Api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
@Setter
public class AulaProfessor {
    private String horario;
    private String materia;
    private String turmaNome;
    private String turmaId;
}
