package staff.Api.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import staff.Api.model.AlunoList;
import staff.Api.model.HorarioTurma;
import staff.Api.model.ProfessorLIst;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Turma {
    @Id
    private String id;
    private String nome;
    private ProfessorLIst professorResponsavel;
    private List<ProfessorLIst> professoresAuxiliares;
    private List<AlunoList> alunos;
    private String periodo;
    private List<HorarioTurma> horarios;
}
