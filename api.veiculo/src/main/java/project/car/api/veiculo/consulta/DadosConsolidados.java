package project.car.api.veiculo.consulta;

import project.car.api.veiculo.placa.DadosPlaca;
import project.car.api.veiculo.veiculo.DadosCadastroVeiculo;

public record DadosConsolidados(DadosCadastroVeiculo dadosVeiculo, DadosPlaca dadosPlaca) {


}
