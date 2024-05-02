package staff.Api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import staff.Api.entity.Aluno;
import staff.Api.entity.Turma;
import staff.Api.mapper.PresencaMapper;
import staff.Api.model.InfoPresencaAluno;
import staff.Api.model.Presenca;
import staff.Api.repository.AlunoRepository;
import staff.Api.repository.TurmaRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TurmaService {
    private final TurmaRepository turmaRepository;
    private  final AlunoRepository alunoRepository;

    public List<Turma> turmasByProfessorId(String professorId){
        return turmaRepository.findByProfessor(professorId);
    }

    public List<InfoPresencaAluno> obterPresencaPorTurma(String turmaId) {
        List<InfoPresencaAluno> infoPresencaAlunos = new ArrayList<>();

        // Buscar os alunos da turma
        List<Aluno> alunos = alunoRepository.alunosByTurma(turmaId);

        // Mapear as presenças dos alunos
        for (Aluno aluno : alunos) {
            InfoPresencaAluno infoPresencaAluno = PresencaMapper.mapAlunoToInfoPresenca(aluno, aluno.getPresencas());
            infoPresencaAlunos.add(infoPresencaAluno);
        }

        return infoPresencaAlunos;
    }
}
