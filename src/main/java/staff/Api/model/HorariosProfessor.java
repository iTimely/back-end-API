package staff.Api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class HorariosProfessor {
    private String dia;
    private List<HorarioTurno> aulasManha;
    private List<HorarioTurno> aulasTarde;
}
