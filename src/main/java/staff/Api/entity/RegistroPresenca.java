package staff.Api.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import staff.Api.enums.Periodo;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegistroPresenca {
    @Id
    private String id;
    private String turmaId;
    private Professor professor;
    private LocalDate date;
    private Periodo periodo;
    private List<Presenca> presencaList;


}
