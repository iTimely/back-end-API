package staff.Api.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import staff.Api.entity.Chamada;
import staff.Api.model.Presenca;
import staff.Api.model.PresencaList;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class PresencaMapper {

    public static List<Presenca> mapChamadaToPresencas(Chamada chamada) {
        List<Presenca> presencas = new ArrayList<>();

        for (PresencaList registro : chamada.getRegistoPresencas()) {
            Presenca presenca = new Presenca();

            presenca.setMateria(chamada.getProfessor().getMateria());
            presenca.setData(chamada.getData());
            presenca.setPeriodo(chamada.getPeriodo());
            presenca.setPresenca(registro.isPresente());
            presenca.setAlunoId(registro.getAlunoId());
            presencas.add(presenca);
        }

        return presencas;
    }
}
