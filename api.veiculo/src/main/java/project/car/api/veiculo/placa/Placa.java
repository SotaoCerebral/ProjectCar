package project.car.api.veiculo.placa;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.car.api.veiculo.veiculo.DadosCadastroVeiculo;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Placa {

    private String marca;
    private String modelo;
    private String chassi;
    private Boolean licenciado;



    public Placa(DadosPlaca dados) {
        this.marca = dados.marca();
        this.modelo = dados.modelo();
        this.chassi = dados.chassi();
        this.licenciado = dados.licenciado();
    }

    public Placa(Placa dados) {
        this.marca = dados.getMarca();
        this.modelo = dados.getModelo();
        this.chassi = dados.getChassi();
        this.licenciado = dados.getLicenciado();

    }
}
