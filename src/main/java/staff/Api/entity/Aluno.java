package staff.Api.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import staff.Api.dto.TurmaDto;
import staff.Api.model.Endereco;
import staff.Api.model.Presenca;
import staff.Api.model.Responsavel;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Aluno {
    @Id
    private String id;
    private String nomeCompleto;
    private Integer idade;
    private Endereco endereco;
    private List<Responsavel> responsaveis;
    private List<Presenca> presencas;
    private TurmaDto turma;

    public void adicionarPresenca(Presenca presenca) {
        this.presencas.add(presenca);
    }
}
