package staff.Api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import staff.Api.dto.AlunoRelatorioDto;
import staff.Api.dto.AlunoRelatorioEmailDto;
import staff.Api.dto.ResponsavelDto;
import staff.Api.dto.TurmaChamadaDto;
import staff.Api.entity.Aluno;
import staff.Api.entity.Turma;
import staff.Api.mapper.PresencaMapper;
import staff.Api.mapper.TurmaMapper;
import staff.Api.model.InfoPresencaAluno;
import staff.Api.model.Presenca;
import staff.Api.repository.AlunoRepository;
import staff.Api.repository.TurmaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
public class TurmaService {
    private final TurmaRepository turmaRepository;
    private  final AlunoRepository alunoRepository;
    private final TurmaMapper turmaMapper;

    public List<Turma> turmasByProfessorId(String professorId){
        return turmaRepository.findByProfessor(professorId);
    }

    public TurmaChamadaDto turmaByID(String turmaId){
        Turma turma = turmaRepository.findById(turmaId);
        TurmaChamadaDto turmaDto = TurmaMapper.toTurma(turma);
        return turmaDto;
    }

    public List<AlunoRelatorioDto> getRelatorioTurma(String turmaId) {
        Turma turma = turmaRepository.findById(turmaId);
        if (turma == null) {
            throw new RuntimeException("Turma não encontrada");
        }

        return turma.getAlunos().stream().map(aluno -> {
            Aluno alunoEntidade = alunoRepository.findById(aluno.getAlunoId());
            if (alunoEntidade == null) {
                throw new RuntimeException("Aluno não encontrado: " + aluno.getAlunoId());
            }

            long totalPresencas = alunoEntidade.getPresencas().stream()
                    .filter(Presenca::isPresenca) // Verifica se a presença é true
                    .count();

            long totalFaltas = alunoEntidade.getPresencas().stream()
                    .filter(presenca -> !presenca.isPresenca()) // Verifica se a presença é false
                    .count();

            System.out.println("Aluno: " + aluno.getNome());
            System.out.println("Total Presenças: " + totalPresencas);
            System.out.println("Total Faltas: " + totalFaltas);

            return new AlunoRelatorioDto(aluno.getAlunoId(), aluno.getNome(), (int) totalPresencas, (int) totalFaltas);
        }).collect(Collectors.toList());
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

    public List<AlunoRelatorioEmailDto> getRelatorioTurmaEmail(String turmaId) {
        List<Aluno> alunos = alunoRepository.alunosByTurma(turmaId);
        List<AlunoRelatorioEmailDto> relatorio = new ArrayList<>();

        for (Aluno aluno : alunos) {
            int totalPresencas = 0;
            int totalFaltas = 0;
            for (Presenca presenca : aluno.getPresencas()) {
                if (presenca.isPresenca()) {
                    totalPresencas++;
                } else {
                    totalFaltas++;
                }
            }

            List<ResponsavelDto> responsavelDtos = aluno.getResponsaveis().stream()
                    .map(responsavel -> new ResponsavelDto(responsavel.getNomeCompleto(), responsavel.getEmail()))
                    .collect(Collectors.toList());

            relatorio.add(new AlunoRelatorioEmailDto(aluno.getNomeCompleto(), responsavelDtos, totalPresencas, totalFaltas));
        }

        return relatorio;
    }
}
