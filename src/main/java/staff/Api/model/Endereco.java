package staff.Api.model;

import lombok.Data;

@Data
public class Endereco {
    private String logradouro;
    private String cidade;
    private Integer numero;
    private String bairro;
    private String CEP;
    private String estado;

}
