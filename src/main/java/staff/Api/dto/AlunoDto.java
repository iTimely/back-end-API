package staff.Api.dto;

import lombok.*;
import staff.Api.entity.Responsavel;

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
