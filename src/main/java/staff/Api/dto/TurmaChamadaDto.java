package staff.Api.dto;

import lombok.*;
import staff.Api.model.AlunoChamada;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TurmaChamadaDto {
    private String turmaId;
    private String nome;
    private List<AlunoChamada> alunos;

    @Override
    public String toString() {
        return "TurmaChamadaDto{" +
                "turmaId='" + turmaId + '\'' +
                ", nome='" + nome + '\'' +
                ", alunos=" + alunos.stream()
                .map(AlunoChamada::toString)
                .collect(Collectors.joining(", ")) +
                '}';
    }
}
