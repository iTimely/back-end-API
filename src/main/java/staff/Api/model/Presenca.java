package staff.Api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Presenca {
    private String materia;
    private String data;
    private String periodo;
    private Boolean presenca;
    private String alunoId;


    public boolean isPresenca() {
        return presenca;
    }
}
