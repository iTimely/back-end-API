package staff.Api.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Turma {
    @Id
    private String id;
    private String nome;
    private Professor professorResponsavel;
    private List<Professor> professoresAuxiliares;
    private List<Aluno> alunos;
}
