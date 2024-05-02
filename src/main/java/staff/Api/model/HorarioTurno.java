package staff.Api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@Builder
public class HorarioTurno {
    private String horario;
    private String materia;
    private String turmaNome;
    private String turmaId;
}
