package staff.Api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AlunoChamada {
    String alunoId;
    String nome;
    Boolean presencas;

    @Override
    public String toString() {
        return "AlunoChamada{" +
                "id='" + alunoId + '\'' +
                ", nome='" + nome + '\'' +
                '}';
    }
}
