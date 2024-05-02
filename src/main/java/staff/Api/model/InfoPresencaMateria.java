package staff.Api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InfoPresencaMateria {
    private String materia;
    private String percentualFalta;
    private int numeroFaltas;
}
