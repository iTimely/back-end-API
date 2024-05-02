package staff.Api.mapper;

import staff.Api.entity.Aluno;
import staff.Api.model.InfoPresencaAluno;
import staff.Api.model.InfoPresencaMateria;
import staff.Api.model.Presenca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PresencaMapper {
    public static InfoPresencaAluno mapAlunoToInfoPresenca(Aluno aluno, List<Presenca> presencas) {
        // Mapear as presenças do aluno para InfoPresencaMateria
        List<InfoPresencaMateria> infoPresencaMaterias = presencas.stream()
                .map(presenca -> new InfoPresencaMateria(
                        presenca.getMateria(),
                        calcularPercentualFalta(presencas, presenca.getMateria()),
                        contarFaltas(presencas, presenca.getMateria())
                ))
                .collect(Collectors.toList());

        // Criar e retornar o objeto InfoPresencaAluno
        return new InfoPresencaAluno(
                aluno.getId(),
                aluno.getNomeCompleto(),
                infoPresencaMaterias
        );
    }

    // Método auxiliar para calcular o percentual de falta
    private static String calcularPercentualFalta(List<Presenca> presencas, String materia) {
        long totalAulas = presencas.stream()
                .filter(presenca -> presenca.getMateria().equals(materia))
                .count();

        long totalPresencas = presencas.stream()
                .filter(presenca -> presenca.getMateria().equals(materia) && presenca.isPresenca())
                .count();

        double percentual = (double) totalPresencas / totalAulas * 100;
        return String.format("%.2f%%", percentual);
    }

    // Método auxiliar para contar o número de faltas
    private static int contarFaltas(List<Presenca> presencas, String materia) {
        return (int) presencas.stream()
                .filter(presenca -> presenca.getMateria().equals(materia) && !presenca.isPresenca())
                .count();
    }
}
