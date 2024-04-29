package staff.Api.dto;

import lombok.*;
import staff.Api.model.Responsavel;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AlunoDto {
    private String turma;
    private Integer idade;
    private Responsavel responsavel;
}
