package staff.Api.mapper;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import staff.Api.entity.Chamada;
import staff.Api.model.ProfessorList;
import staff.Api.request.ChamadaRequest;


@Getter
@Setter
@Component
public class ChamadaMapper {
    public Chamada mapChamadaRequestToChamada(ChamadaRequest chamadaRequest) {
        return Chamada.builder()
                .professor(ProfessorList.builder()
                        .nome(chamadaRequest.getProfessorNome())
                        .professorId(chamadaRequest.getProfessorId())
                        .materia(chamadaRequest.getProfessorMateria())
                        .build())
                .data(chamadaRequest.getData())
                .periodo(chamadaRequest.getPeriodo())
                .turmaId(chamadaRequest.getTurmaId())
                .registoPresencas(chamadaRequest.getRegistroPresencas())
                .build();
    }

}
