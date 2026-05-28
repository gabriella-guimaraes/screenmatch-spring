package br.com.screenmatch;

import br.com.screenmatch.Principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);

		var menu = """
            \n*** SELECIONE O PROJETO ***
            1 - ScreenMatch (projeto do curso)
            2 - Tabela FIPE (desafio)
            """;

		System.out.println(menu);
		var opcao = scanner.nextLine();

		switch (opcao) {
			case "1" -> {
				br.com.screenmatch.Principal.Principal principal = new br.com.screenmatch.Principal.Principal();
				principal.exibeMenu();
			}
			case "2" -> {
				br.com.screenmatch.Desafios.tabelaFipe.principal.Principal desafio =
						new br.com.screenmatch.Desafios.tabelaFipe.principal.Principal();
				desafio.exibeMenu();
			}
			default -> System.out.println("Opção inválida.");
		}

	}
}
