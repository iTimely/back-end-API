package staff.Api.dto;

import lombok.Builder;
import lombok.Data;
import staff.Api.entity.Turma;

import java.util.List;

@Data
@Builder
public class ProfessorDto {
    private String id;
    private String nomeCompleto;
    private Integer idade;
    private String materia;
    private List<Turma> turma;
    private String email;
    private String telefone;
}
