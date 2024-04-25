package staff.Api.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Aluno {
    @Id
    private String id;
    private String turma;
    private Integer idade;
    @DocumentReference
    private Responsavel responsavel;
    @DocumentReference
    private Endereco endereco;

}
