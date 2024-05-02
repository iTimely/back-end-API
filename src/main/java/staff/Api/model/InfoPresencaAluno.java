package staff.Api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InfoPresencaAluno {
    private String alunoId;
    private String alunoNome;
    private List<InfoPresencaMateria> percentualDeFalta;
}
