package staff.Api.mapper;

import org.springframework.stereotype.Component;
import staff.Api.dto.TurmaChamadaDto;
import staff.Api.entity.Turma;
import staff.Api.model.AlunoChamada;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TurmaMapper {

    public static TurmaChamadaDto toTurma(Turma turma) {
        List<AlunoChamada> alunos = turma.getAlunos().stream()
                .map(aluno -> new AlunoChamada(
                        aluno.getAlunoId() != null ? aluno.getAlunoId() : "id_desconhecido",
                        aluno.getNome(),
                        aluno.getPresencas() != null ? aluno.getPresencas() : false
                ))
                .collect(Collectors.toList());

        return TurmaChamadaDto.builder()
                .turmaId(turma.getId())
                .nome(turma.getNome())
                .alunos(alunos)
                .build();
    }
}
