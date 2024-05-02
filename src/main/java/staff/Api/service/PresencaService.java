package staff.Api.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import staff.Api.entity.Aluno;
import staff.Api.model.Presenca;
import staff.Api.repository.AlunoRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class PresencaService {
    private final AlunoRepository alunoRepository;
    public void atualizarPresencasDosAlunos(List<Presenca> presencas) {
        for (Presenca presenca : presencas) {
            String alunoId = presenca.getAlunoId();

            Aluno aluno = alunoRepository.findById(alunoId);

            if (aluno != null) {
                aluno.adicionarPresenca(presenca);
                alunoRepository.save(aluno);
            }
        }
    }
}
