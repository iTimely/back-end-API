package staff.Api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class ProfessorList {
    private String nome;
    private String professorId;
    private String materia;
}
