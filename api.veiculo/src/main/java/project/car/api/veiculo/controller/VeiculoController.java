package project.car.api.veiculo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import project.car.api.veiculo.consulta.DadosConsolidados;
import project.car.api.veiculo.placa.DadosPlaca;
import project.car.api.veiculo.veiculo.DadosCadastroVeiculo;
import project.car.api.veiculo.veiculo.Veiculo;
import project.car.api.veiculo.veiculo.VeiculoRepository;


@RestController
@RequestMapping("veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<DadosConsolidados> cadastro(@RequestBody DadosCadastroVeiculo dados){

        DadosPlaca dadosPlaca = consultaPlaca(String.valueOf(dados));
        DadosConsolidados dadosConsolidados = new DadosConsolidados(dados,dadosPlaca);

        repository.save(new Veiculo(dados));

        return ResponseEntity.ok(dadosConsolidados);
    }


    @GetMapping("/{placa}")
    public DadosPlaca consultaPlaca(@PathVariable("placa")String dados){

        RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<DadosPlaca> resp = restTemplate.getForEntity
                (String.format("https://my.api.mockaroo.com/veiculos?key=55ad1cd0&placa=%s",dados)
                    ,DadosPlaca.class);


        return resp.getBody();
    }

}
