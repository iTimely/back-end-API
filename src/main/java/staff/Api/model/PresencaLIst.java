package staff.Api.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class PresencaLIst {
    private Boolean presente;
    private String alunoId;
}
