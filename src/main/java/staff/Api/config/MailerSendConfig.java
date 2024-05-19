package staff.Api.config;

import com.mailersend.sdk.MailerSend;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MailerSendConfig {
    @Value("${mailersend.api.token}")
    private String apiToken;

    @Bean
    public MailerSend mailerSend() {
        MailerSend mailerSend = new MailerSend();
        mailerSend.setToken(apiToken);
        return mailerSend;
    }
}
