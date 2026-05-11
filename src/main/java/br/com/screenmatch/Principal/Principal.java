package br.com.screenmatch.Principal;

import br.com.screenmatch.service.ConsumoApi;

import java.util.Scanner;

public class Principal {
    private Scanner leitura = new Scanner(System.in);
    private final String ENDERECO = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=" + System.getenv("OMDB_API_KEY");
    private ConsumoApi consumoApi = new ConsumoApi();

    public void exibeMenu() {
        System.out.println("Digite o nome da série para busca: ");

        var nomeSerie = leitura.nextLine();

        if (API_KEY == null) {
            throw new RuntimeException("API key não configurada");
        }

        var enderecoSerie = ENDERECO + nomeSerie.replace(" ", "+") + API_KEY;

        var json = consumoApi.obterDados(enderecoSerie);
        System.out.println(json);

    }
}
