package staff.Api.entity;

import io.mongock.utils.field.Field;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.util.List;


@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Professor {
    @Id
    private String id;

    @Field("nome_completo")
    private String nomeCompleto;
    private Integer idade;
    private String materia;
    private List<TurmaList> turmas;
    private String login;
    private String senha;
    private String telefone;
    private String email;
}