package staff.Api.request;

import lombok.*;

import staff.Api.model.TurmaList;

import java.util.List;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProfessorRequest {
    private String nomeCompleto;
    private Integer idade;
    private String materia;
    private List<TurmaList> turmas;
    private String login;
    private String senha;
    private String telefone;
    private String email;
}