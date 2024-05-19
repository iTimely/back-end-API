package staff.Api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import staff.Api.dto.AlunoRelatorioEmailDto;
import staff.Api.dto.ResponsavelDto;
import staff.Api.service.TurmaService;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class EmailController {
    @Autowired
    private TurmaService turmaService;
    @GetMapping("/enviar-email-pais")
    public ResponseEntity<String> enviarEmailPais(@RequestParam String turmaId) {
        // Obtenha os detalhes do relatório da turma, presumindo que você tenha um serviço para isso
        List<AlunoRelatorioEmailDto> relatorio = turmaService.getRelatorioTurmaEmail(turmaId);

        for (AlunoRelatorioEmailDto aluno : relatorio) {
            // Construa o corpo do e-mail
            String mensagem = "Prezado responsável, \n\n" +
                    "Gostaríamos de informar que o aluno " + aluno.getNomeCompleto() +
                    " está ausente em algumas aulas. Por favor, entre em contato com a escola para mais informações.\n\n" +
                    "Atenciosamente,\n" +
                    "Administração";

            // Envie o e-mail para cada responsável
            for (ResponsavelDto responsavel : aluno.getResponsaveis()) {
                enviarEmail(responsavel.getEmail(), "Alerta de Ausência do Aluno", mensagem);
            }
        }

        return ResponseEntity.ok("E-mails enviados com sucesso para os pais!");
    }

    private void enviarEmail(String destinatario, String assunto, String mensagem) {
        // Configurações da autenticação do Mailgun
        String username = "nicolemattesafonso06@gmail.com";
        String password = "itimely9839013";

        // Construção da URI para a API do Mailgun
        String host = "https://api.mailgun.net";
        String pathname = "/v3/sandbox97528496f6f142a7b38dcdbf4d7109ad.mailgun.org/messages"; // Substitua YOUR_DOMAIN_NAME pelo seu domínio do Mailgun

        // Construa os parâmetros do corpo da solicitação HTTP
        HashMap<String, String> params = new HashMap<>();
        params.put("from", "Administração <admin@escola.com>");
        params.put("to", destinatario);
        params.put("subject", assunto);
        params.put("text", mensagem);

        // Converta os parâmetros em uma string de consulta
        String query = params.keySet().stream()
                .map(key -> key + "=" + URLEncoder.encode(params.get(key), StandardCharsets.UTF_8))
                .collect(Collectors.joining("&"));

        // Construa a solicitação HTTP com a autenticação e os parâmetros
        String auth = Base64.getEncoder().encodeToString((username + ":" + password).getBytes());
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(host + pathname + "?" + query))
                .header("Authorization", "Basic " + auth)
                .build();

        // Envie a solicitação HTTP para a API do Mailgun
        HttpClient httpClient = HttpClient.newBuilder().build();
        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Resposta da API do Mailgun: " + response.body());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
