package staff.Api.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Presenca {
    private String alunoId;
    private Boolean presenca;
}
