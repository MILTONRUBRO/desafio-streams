package br.com.devmos.stream.service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import br.com.devmos.stream.model.Jogador;

public class JogadorServiceImpl implements JogadorService {

	@Override
	public boolean verificarArquivoExiste(Path caminho) {
		boolean ret = false;
		try {
			Stream<Path> stream = Files.list(caminho);
			Optional<Path> arq = stream.filter(p -> p.toString().endsWith("dados_jogadores.txt")).findAny();
			ret = arq.isPresent();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return ret;
	}

	@Override
	public List<Jogador> getListaDeJogadores(Path caminho) throws IOException {
		Stream<String> linhas = Files.lines(caminho, StandardCharsets.ISO_8859_1);
		List<String> listaDeLinhas = linhas.collect(Collectors.toList());
		List<Jogador> listaDeJogadores = new ArrayList<>();
		Iterator it = listaDeLinhas.listIterator();
		String str = null;

		while (it.hasNext()) {
			str = (String) it.next();

			String info[] = str.split(",");
			Jogador jogador = new Jogador();
			jogador.setNome(info[0]);
			jogador.setPosicao(info[1]);
			jogador.setIdade(Integer.parseInt(info[2]));
			jogador.setTimeAtual(info[3]);
			jogador.setGolsMarcados(Integer.parseInt(info[4]));

			listaDeJogadores.add(jogador);
		}

		return listaDeJogadores;
	}

	@Override
	public void imprimirJogadorMaisVelho(List<Jogador> jogadores) {
		Integer maiorIdade = jogadores.stream()
				.max(Comparator.comparingInt(Jogador::getIdade))
				.map(jogador -> jogador.getIdade())
				.get();
		System.out.println("O jogador mais velho tem " + maiorIdade + " anos");
	}
	
	@Override
	public Jogador getJogadorMaisVelho(List<Jogador> jogadores) {
		Jogador jogador = jogadores.stream().max(Comparator.comparing(Jogador::getIdade)).get();
		return jogador;
	}

	@Override
	public void imprimirListaDeJogadores(List<Jogador> jogadores) {
		jogadores.forEach(System.out::println);
	}

}
