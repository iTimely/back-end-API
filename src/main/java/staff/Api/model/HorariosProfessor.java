package staff.Api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class HorariosProfessor {
    private String dia;
    private HorarioTurno aulasManha;
    private HorarioTurno aulasTarde;
}
