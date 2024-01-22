package project.car.api.veiculo.veiculo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.car.api.veiculo.placa.DadosPlaca;
import project.car.api.veiculo.placa.Placa;


@Table(name = "veiculos")
@Entity(name = "Veiculo")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Veiculo {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String proprietario;
    private String cpf;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "marca", column = @Column(name = "placa_marca")),
            @AttributeOverride(name = "modelo", column = @Column(name = "placa_modelo")),
            @AttributeOverride(name = "chassi", column = @Column(name = "placa_chassi")),
            @AttributeOverride(name = "licenciado", column = @Column(name = "placa_licenciado"))})
    private Placa placa;


    public Veiculo (DadosCadastroVeiculo dados){
        this.proprietario = dados.proprietario();
        this.cpf = dados.cpf();
        this.placa = new Placa(dados.placa());

    }

}
