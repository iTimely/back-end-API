package staff.Api.entity;

import lombok.Data;

@Data
public class Endereco {
    private String logradouro;
    private String cidade;
    private String numero;
    private String bairro;
    private String cep;
    private String estado;

}
