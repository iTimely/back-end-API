package staff.Api.entity;

import io.mongock.utils.field.Field;
import lombok.*;
import org.springframework.data.annotation.Id;
import staff.Api.dto.TurmaProfessorDto;
import staff.Api.model.Endereco;
import staff.Api.model.HorariosProfessor;
import staff.Api.model.TurmaList;

import java.util.List;


@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Professor {
    @Id
    private String id;
    private String nomeCompleto;
    private Integer idade;
    private String materia;
    private String telefone;
    private String email;
    private String cpf;
    private String login;
    private String senha;
    private Endereco endereco;
    private List<TurmaProfessorDto> turmas;
    private Boolean professorResponsavel;
    private List<HorariosProfessor> horarios;
}