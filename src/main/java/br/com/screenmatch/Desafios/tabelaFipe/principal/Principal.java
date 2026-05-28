package br.com.screenmatch.Desafios.tabelaFipe.principal;

import br.com.screenmatch.Desafios.tabelaFipe.service.ConsumoAPI;

import java.util.Scanner;

public class Principal {
    private Scanner leitura = new Scanner(System.in);
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private final String URL_BASE = "https://parallelum.com.br/fipe/api/v1/";

    public void exibeMenu() {
        String endereco;

        var menu = """
                    *** OPÇÕES ***
                    Carro
                    Moto
                    Caminhão
                    
                    Digite uma das opções para consultar
                    """;

        System.out.println(menu);
        var opcao = leitura.nextLine();

        if (opcao.toLowerCase().contains("carr")) {
            endereco = URL_BASE + "carros/marcas";
        } else if (opcao.toLowerCase().contains("mot")) {
            endereco = URL_BASE + "motos/marcas";
        } else {
            endereco = URL_BASE + "caminhoes/marcas";
        }

        var json = consumoAPI.obterDados(endereco);
        System.out.println(json);



    }
}
