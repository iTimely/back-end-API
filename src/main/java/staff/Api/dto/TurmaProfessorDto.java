package staff.Api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TurmaProfessorDto {
    private String turmaId;
    private String turmaNome;
    private String periodo;
}
