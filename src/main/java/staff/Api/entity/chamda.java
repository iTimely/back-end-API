package staff.Api.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import staff.Api.model.PresencaLIst;
import staff.Api.model.ProfessorLIst;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class chamda {
    @Id
    private String id;
    private ProfessorLIst professor;
    private String data;
    private String periodo;
    private String turmaId;
    private List<PresencaLIst> registroPresencas;
}
