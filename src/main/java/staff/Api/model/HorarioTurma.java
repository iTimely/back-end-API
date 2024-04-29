package staff.Api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class HorarioTurma {
    private String dia;
    private List<AulaTurma> aulas;
}
