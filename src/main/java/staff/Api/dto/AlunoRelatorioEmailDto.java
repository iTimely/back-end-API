package staff.Api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class AlunoRelatorioEmailDto {
    private String nomeCompleto;
    private List<ResponsavelDto> responsaveis;
    private int totalPresencas;
    private int totalFaltas;


}
