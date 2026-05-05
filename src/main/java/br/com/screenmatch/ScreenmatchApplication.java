package br.com.screenmatch;

import br.com.screenmatch.model.DadosEpisodio;
import br.com.screenmatch.model.DadosSerie;
import br.com.screenmatch.service.ConsumoApi;
import br.com.screenmatch.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String apiKey = System.getenv("OMDB_API_KEY");
		if (apiKey == null) {
			throw new RuntimeException("API key não configurada");
		}

		String enderecoSerie = "http://www.omdbapi.com/?t=the+office&apikey=" + apiKey;
		String enderecoEpisodio = "http://www.omdbapi.com/?t=the+office&season=1&episode=2&apikey=" + apiKey;

		var consumoApi = new ConsumoApi();
		var json = consumoApi.obterDados(enderecoSerie);
		System.out.println(json);

		ConverteDados conversor = new ConverteDados();
		DadosSerie dados = conversor.obterdados(json, DadosSerie.class);
		System.out.println(dados);

		json = consumoApi.obterDados(enderecoEpisodio);
		DadosEpisodio dadosEpisodio = conversor.obterdados(json, DadosEpisodio.class);
		System.out.println(dadosEpisodio);
	}
}
