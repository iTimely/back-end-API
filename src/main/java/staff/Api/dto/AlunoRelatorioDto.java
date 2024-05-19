package staff.Api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AlunoRelatorioDto {
    private String alunoId;
    private String nome;
    private int totalPresencas;
    private int totalFaltas;
}
