package com.victor.jpa;

import com.victor.jpa.entity.*;
import com.victor.jpa.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.PageRequest;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Bean
	CommandLineRunner run(
			CategoriaRepository categoriaRepo,
			UsuarioRepository usuarioRepo,
			PerfilRepository perfilRepo,
			VideoRepository videoRepo,
			AvaliacaoRepository avaliacaoRepo,
			VisualizacaoRepository visualizacaoRepo
	) {
		return args -> {
			System.out.println("====== CRIANDO BANCO DE DADOS ======");

			Categoria acao = new Categoria();
			acao.setNome("Ação");
			Categoria comedia = new Categoria();
			comedia.setNome("Comédia");
			categoriaRepo.saveAll(Arrays.asList(acao, comedia));

			Usuario ana = new Usuario();
			ana.setNome("Ana Souza");
			ana.setEmail("ana@email.com");
			ana.setSenha("123");
			ana.setData_cadastro(LocalDateTime.now().minusDays(10));
			Perfil perfilAna = new Perfil();
			perfilAna.setNome_perfil("Ana_Souza");
			perfilAna.setUsuario(ana);
			ana.getPerfis().add(perfilAna);
			usuarioRepo.save(ana);

			Usuario carlos = new Usuario();
			carlos.setNome("Carlos Pereira");
			carlos.setEmail("carlos@email.com");
			carlos.setSenha("456");
			carlos.setData_cadastro(LocalDateTime.now().minusDays(8));
			Perfil perfilCarlos = new Perfil();
			perfilCarlos.setNome_perfil("Carlos_Pereira");
			perfilCarlos.setUsuario(carlos);
			carlos.getPerfis().add(perfilCarlos);
			usuarioRepo.save(carlos);

			Usuario bruna = new Usuario();
			bruna.setNome("Bruna Lima");
			bruna.setEmail("bruna@email.com");
			bruna.setSenha("789");
			bruna.setData_cadastro(LocalDateTime.now().minusDays(5));
			Perfil perfilBruna = new Perfil();
			perfilBruna.setNome_perfil("Bruna_Lima");
			perfilBruna.setUsuario(bruna);
			bruna.getPerfis().add(perfilBruna);
			usuarioRepo.save(bruna);

			Video v1 = new Video("O Agente Noturno", "Agente do FBI em uma conspiração mortal.", 3000, acao);
			Video v2 = new Video("Uma Noite Fora de Série", "Casal entediado em uma aventura perigosa.", 5280, comedia);
			Video v3 = new Video("Resgate 2", "O mercenário Tyler Rake em outra missão mortal.", 7380, acao);
			Video v4 = new Video("As Branquelas", "Dois agentes do FBI se disfarçam de socialites.", 6540, comedia);
			Video v5 = new Video("Missão Impossível 7", "Ethan Hunt e sua equipe enfrentam uma nova ameaça.", 9780, acao);
			Video v6 = new Video("John Wick 4", "John Wick descobre um caminho para derrotar a High Table.", 10140, acao);
			Video v7 = new Video("Gente Grande 2", "Amigos de infância aprendem que envelhecer não significa crescer.", 6060, comedia);
			Video v8 = new Video("Alerta Vermelho", "Um alerta global da Interpol leva a uma caçada aos criminosos mais procurados do mundo.", 7080, acao);
			Video v9 = new Video("Anjos da Lei", "Dois policiais se infiltram em uma escola para desvendar uma rede de tráfico.", 6540, comedia);
			Video v10 = new Video("O Protetor: Capítulo Final", "Robert McCall encontra um novo propósito na Itália, mas seus amigos são ameaçados pela máfia.", 6540, acao);
			Video v11 = new Video("Superbad: É Hoje", "Dois estudantes planejam uma festa épica para perder a virgindade antes da faculdade.", 6780, comedia);
			Video v12 = new Video("Sem Remorso", "Um oficial da marinha busca vingança pela morte de sua esposa.", 6600, acao);
			Video v13 = new Video("A Mentira", "Uma estudante usa o boato de que perdeu a virgindade para se tornar popular.", 5520, comedia);
			Video v14 = new Video("Esquadrão 6", "Seis bilionários forjam suas mortes para criar um esquadrão de elite e combater o crime.", 7680, acao);
			Video v15 = new Video("Ted 2", "O urso de pelúcia Ted luta por seus direitos civis para ser reconhecido como pessoa.", 6900, comedia);
			videoRepo.saveAll(Arrays.asList(v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14, v15));

			visualizacaoRepo.save(new Visualizacao(perfilCarlos, v1, LocalDateTime.now().minusHours(10), 100));
			visualizacaoRepo.save(new Visualizacao(perfilCarlos, v3, LocalDateTime.now().minusHours(8), 100));
			visualizacaoRepo.save(new Visualizacao(perfilCarlos, v5, LocalDateTime.now().minusHours(5), 80));
			visualizacaoRepo.save(new Visualizacao(perfilCarlos, v6, LocalDateTime.now().minusHours(4), 100));
			visualizacaoRepo.save(new Visualizacao(perfilCarlos, v8, LocalDateTime.now().minusHours(3), 100));
			visualizacaoRepo.save(new Visualizacao(perfilCarlos, v14, LocalDateTime.now().minusHours(2), 90));

			visualizacaoRepo.save(new Visualizacao(perfilBruna, v2, LocalDateTime.now().minusHours(20), 100));
			visualizacaoRepo.save(new Visualizacao(perfilBruna, v4, LocalDateTime.now().minusHours(15), 100));
			visualizacaoRepo.save(new Visualizacao(perfilBruna, v9, LocalDateTime.now().minusHours(12), 100));
			visualizacaoRepo.save(new Visualizacao(perfilBruna, v11, LocalDateTime.now().minusHours(11), 100));
			visualizacaoRepo.save(new Visualizacao(perfilBruna, v13, LocalDateTime.now().minusHours(10), 50));

			visualizacaoRepo.save(new Visualizacao(perfilAna, v1, LocalDateTime.now().minusDays(2), 100));
			visualizacaoRepo.save(new Visualizacao(perfilAna, v2, LocalDateTime.now().minusDays(1), 100));
			visualizacaoRepo.save(new Visualizacao(perfilAna, v6, LocalDateTime.now().minusDays(1), 70));
			visualizacaoRepo.save(new Visualizacao(perfilAna, v10, LocalDateTime.now().minusHours(2), 100));

			avaliacaoRepo.save(new Avaliacao(perfilCarlos, v1, 5, "Excelente!"));
			avaliacaoRepo.save(new Avaliacao(perfilCarlos, v3, 4, "Muita ação, gostei."));
			avaliacaoRepo.save(new Avaliacao(perfilCarlos, v6, 5, "Melhor da franquia."));
			avaliacaoRepo.save(new Avaliacao(perfilCarlos, v8, 3, "Divertido, mas esquecível."));

			avaliacaoRepo.save(new Avaliacao(perfilBruna, v2, 5, "Hilário, recomendo."));
			avaliacaoRepo.save(new Avaliacao(perfilBruna, v4, 5, "Um clássico da comédia."));
			avaliacaoRepo.save(new Avaliacao(perfilBruna, v9, 4, "Muito engraçado."));
			avaliacaoRepo.save(new Avaliacao(perfilBruna, v11, 4, "Ótima comédia adolescente."));

			avaliacaoRepo.save(new Avaliacao(perfilAna, v1, 4, "Bom filme."));
			avaliacaoRepo.save(new Avaliacao(perfilAna, v6, 5, "Incrível!"));
			avaliacaoRepo.save(new Avaliacao(perfilAna, v10, 5, "Final emocionante."));
			avaliacaoRepo.save(new Avaliacao(perfilAna, v14, 2, "Muito barulhento e confuso."));

			System.out.println("====== BANCO DE DADOS POPULADO COM SUCESSO ======");

			System.out.println("\n====== RESULTADO DAS CONSULTAS ======\n");

			System.out.println("--- 1. Buscar vídeos pelo título com 'Missão' ---");
			List<Video> videosPorTitulo = videoRepo.findByTituloContainingIgnoreCaseOrderByTituloAsc("Missão");
			videosPorTitulo.forEach(v -> System.out.println("  - " + v.getTitulo()));
			System.out.println();

			System.out.println("--- 2. Todos os vídeos da categoria 'Ação' ordenados por título ---");
			List<Video> videosPorCategoria = videoRepo.findByCategoriaNomeIgnoreCaseOrderByTituloAsc("Ação");
			videosPorCategoria.forEach(v -> System.out.println("  - " + v.getTitulo()));
			System.out.println();

			System.out.println("--- 3. Top 10 vídeos mais bem avaliados ---");
			List<Video> topAvaliados = videoRepo.findTopRatedVideos(PageRequest.of(0, 10));
			topAvaliados.forEach(v -> System.out.println("  - " + v.getTitulo()));
			System.out.println();

			System.out.println("--- 4. Top 10 vídeos mais assistidos ---");
			List<Video> topAssistidos = videoRepo.findTopWatchedVideos(PageRequest.of(0, 10));
			topAssistidos.forEach(v -> System.out.println("  - " + v.getTitulo()));
			System.out.println();

			System.out.println("--- 5. O usuário que mais assistiu vídeos ---");
			List<Usuario> topUsuario = usuarioRepo.findTopWatcher(PageRequest.of(0, 1));
			if (!topUsuario.isEmpty()) {
				System.out.println("  - Usuário: " + topUsuario.get(0).getNome());
			} else {
				System.out.println("  - Nenhum usuário encontrado.");
			}
			System.out.println();
		};
	}
}