package br.com.screenmatch;

import br.com.screenmatch.service.ConsumoApi;
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
		String endereco = "http://www.omdbapi.com/?t=the+office&apikey=" + apiKey;

		var consumoApi = new ConsumoApi();
		var json = consumoApi.obterDados(endereco);
		System.out.println(json);
	}
}
