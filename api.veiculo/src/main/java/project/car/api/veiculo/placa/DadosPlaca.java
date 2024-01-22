package project.car.api.veiculo.placa;

import jakarta.validation.constraints.NotBlank;

public record DadosPlaca(String marca,
                         String modelo,

                         String chassi,
                         boolean licenciado) {

}
