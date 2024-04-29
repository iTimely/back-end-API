package staff.Api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Presenca {
    private String materia;
    private String data;
    private String periodo;
    private Boolean presenca;
}
