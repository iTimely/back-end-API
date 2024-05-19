package staff.Api.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import staff.Api.model.AlunoChamada;
import staff.Api.model.HorarioTurma;
import staff.Api.model.ProfessorList;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Turma {
    @Id
    private String id;
    private String nome;
    private ProfessorList professorResponsavel;
    private List<ProfessorList> professoresAuxiliares;
    private List<AlunoChamada> alunos;
    private String periodo;
    private List<HorarioTurma> horarios;

//    @Override
//    public String toString() {
//        String horariosStr = horarios.stream()
//                .map(horario -> {
//                    String aulasStr = horario.getAulas().stream()
//                            .map(aula -> {
//                                int index = horario.getAulas().indexOf(aula) + 1; // Índice da aula (1-based)
//                                String horarioAula = index + "° aula"; // Define o horário da aula
//                                return "{" +
//                                        "horario='" + horarioAula + "'," +
//                                        " materia='" + aula.getMateria() + "'," +
//                                        " nomeProfessor='" + aula.getNomeProfessor() + "'," +
//                                        " professorId='" + aula.getProfessorId() + "'" +
//                                        '}';
//                            })
//                            .collect(Collectors.joining(",\n                    "));
//                    return "{" +
//                            "dia='" + horario.getDia() + '\'' +
//                            ", aulas=[\n                    " + aulasStr + "\n                ]" +
//                            '}';
//                })
//                .collect(Collectors.joining(",\n            "));
//
//        return "Turma{\n" +
//                "    id='" + id + "',\n" +
//                "    nome='" + nome + "',\n" +
//                "    horarios=[\n            " + horariosStr + "\n        ]" +
//                "\n    }";
//    }
}
