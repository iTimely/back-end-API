package staff.Api.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import staff.Api.model.PresencaList;
import staff.Api.model.ProfessorList;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Chamada {
    @Id
    private String id;
    private ProfessorList professor;
    private String data;
    private String periodo;
    private String turmaId;
    private List<PresencaList> registoPresencas;
}
