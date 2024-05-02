package staff.Api.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import staff.Api.model.PresencaList;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class ChamadaRequest {
    private String professorNome;
    private String professorId;
    private String professorMateria;
    private String data;
    private String periodo;
    private String turmaId;
    private List<PresencaList> registroPresencas;
}
