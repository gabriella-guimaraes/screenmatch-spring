package br.com.screenmatch.Principal;

import br.com.screenmatch.model.DadosSerie;
import br.com.screenmatch.model.DadosTemporada;
import br.com.screenmatch.service.ConsumoApi;
import br.com.screenmatch.service.ConverteDados;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Principal {
    private Scanner leitura = new Scanner(System.in);
    private final String ENDERECO = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=" + System.getenv("OMDB_API_KEY");
    private ConsumoApi consumoApi = new ConsumoApi();
    private ConverteDados conversor = new ConverteDados();

    public void exibeMenu() {
//        System.out.println("Digite o nome da série para busca: ");
//
//        var nomeSerie = leitura.nextLine();
//
//        if (API_KEY == null) {
//            throw new RuntimeException("API key não configurada");
//        }
//
//        var enderecoSerie = ENDERECO + nomeSerie.replace(" ", "+") + API_KEY;
//
//        var json = consumoApi.obterDados(enderecoSerie);
//        System.out.println(json);
//
//        DadosSerie dados = conversor.obterdados(json, DadosSerie.class);
//        System.out.println(dados);
//
//
//        List<DadosTemporada> temporadas = new ArrayList<>();
//
//		for(int i = 1; i <= dados.totalTemporadas(); i++) {
//			String enderecoTemporada = ENDERECO + nomeSerie.replace(" ", "+") + "&season=" + i + API_KEY;
//			json = consumoApi.obterDados(enderecoTemporada);
//			DadosTemporada dadosTemporada = conversor.obterdados(json, DadosTemporada.class);
//			temporadas.add(dadosTemporada);
//		}
//
//		temporadas.forEach(System.out::println);
//
//        temporadas.forEach(t -> t.episodios().forEach(e -> System.out.println(e.titulo()))); // Lambda

        List<String> jedis = Arrays.asList("Anakin Skywalker", "Obi-Wan Kenobi", "Mace Windu", "Yoda");

        jedis.stream() // operações encadeadas
                .sorted()
                .limit(2)
                .filter(n -> n.startsWith("A"))
                .map(n -> n.toUpperCase())
                .forEach(System.out::println);

    }
}
