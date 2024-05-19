package staff.Api.controller;

import com.mailersend.sdk.MailerSend;
import com.mailersend.sdk.MailerSendResponse;
import com.mailersend.sdk.emails.Email;
import com.mailersend.sdk.exceptions.MailerSendException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import staff.Api.dto.AlunoRelatorioEmailDto;
import staff.Api.dto.ResponsavelDto;
import staff.Api.dto.TurmaChamadaDto;
import staff.Api.entity.Turma;
import staff.Api.model.InfoPresencaAluno;
import staff.Api.service.TurmaService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/turma")
public class TurmaController {
    private final TurmaService turmaService;

    @GetMapping("/byProfessor")
    public ResponseEntity<?> turmasByProfessorId(@RequestParam String professorId) {
        List<Turma> turmas = turmaService.turmasByProfessorId(professorId);

        if (!turmas.isEmpty()) {
            return ResponseEntity.ok(turmas);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Turmas não localizadas para o professor com ID " + professorId);
        }
    }

    @GetMapping("/turmaById")
    public ResponseEntity<TurmaChamadaDto> turma(@RequestParam String turmaId){
        TurmaChamadaDto turma = turmaService.turmaByID(turmaId);
        return ResponseEntity.ok(turma);
    }

    @GetMapping("/presenca/{turmaId}")
    public List<InfoPresencaAluno> obterPresencaPorTurma(@PathVariable String turmaId) {
        return turmaService.obterPresencaPorTurma(turmaId);
    }

//    @GetMapping("/relatorio/enviar-email")
//    public ResponseEntity<String> enviarEmailFaltas(@RequestParam String turmaId) {
//        List<AlunoRelatorioEmailDto> relatorio = turmaService.getRelatorioTurmaEmail(turmaId);
//
//        for (AlunoRelatorioEmailDto aluno : relatorio) {
//            double percentualFaltas = aluno.getTotalFaltas() / (double) (aluno.getTotalPresencas() + aluno.getTotalFaltas());
//            if (percentualFaltas > 0.8) {
//                sendEmail(aluno);
//            }
//        }
//
//        return ResponseEntity.ok("Emails enviados com sucesso!");
//    }

    @PostMapping("/relatorio/enviar-email-todos")
    public ResponseEntity<String> enviarEmailTodos(@RequestParam String turmaId) {
        List<AlunoRelatorioEmailDto> relatorio = turmaService.getRelatorioTurmaEmail(turmaId);

        for (AlunoRelatorioEmailDto aluno : relatorio) {
            String messageBody = "Informamos que o aluno " + aluno.getNomeCompleto() + " possui um percentual de faltas atual de " +
                    aluno.getTotalFaltas() + " faltas em um total de " + (aluno.getTotalPresencas() + aluno.getTotalFaltas()) + " dias.\n\n";
            sendEmail(aluno, messageBody);
        }

        return ResponseEntity.ok("Emails enviados com sucesso para todos os pais!");
    }
    private void sendEmail(AlunoRelatorioEmailDto aluno, String messageBody) {
        Email email = new Email();

        email.setFrom("Administração", "admin@escola.com");

        for (ResponsavelDto responsavel : aluno.getResponsaveis()) {
            email.addRecipient(responsavel.getNomeCompleto(), responsavel.getEmail());
        }

        email.setSubject("Relatório de Faltas");
        email.setPlain("Prezado responsável, \n\n" + messageBody + "Por favor, entre em contato com a escola para mais informações.\n\n" +
                "Atenciosamente,\n" +
                "Administração");

        MailerSend ms = new MailerSend();

        ms.setToken("mlsn.ec02ce7d07533898453b6c29da99b18c3cf6c2bf6b22b5f54f6d2adc89dd7c47");
        try {
            MailerSendResponse response = ms.emails().send(email);
            System.out.println("Email enviado com sucesso para: " + response.messageId);
        } catch (MailerSendException e) {
            e.printStackTrace();
        }
    }
}
