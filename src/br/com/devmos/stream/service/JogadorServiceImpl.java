package br.com.devmos.stream.service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collector;
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
			jogador.setAssistencias(Integer.parseInt(info[5]));
			jogador.setCartoesAmarelo(Integer.parseInt(info[6]));
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
		Jogador jogador = jogadores.stream().max(Comparator.comparingInt(Jogador::getIdade)).get();
		return jogador;
	}

	@Override
	public void imprimirListaDeJogadores(List<Jogador> jogadores) {
		jogadores.forEach(System.out::println);
	}

	@Override
	public List<Jogador> getListaArtilheiros(List<Jogador> jogadores) {
		List<Jogador> artilheiros = jogadores.stream()
								.sorted(Comparator.comparingInt(Jogador::getGolsMarcados).reversed())
								.limit(3)
								.collect(Collectors.toList());
		
		return artilheiros;
	}

	@Override
	public double getMediaDasIdades(List<Jogador> jogadores) {
		double media = jogadores.stream()
				.mapToDouble(jogador -> jogador.getIdade())
				.average()
				.getAsDouble();
		
		return media;
	}
	
	@Override
	public double getMediaDeGols(List<Jogador> jogadores) {
		return jogadores.parallelStream()
				.mapToDouble(Jogador::getGolsMarcados)
				.average()
				.getAsDouble();
		
	}

	@Override
	public int getQuantidadeGols(List<Jogador> jogadores) {
		return jogadores.stream()
					.mapToInt(jogador -> jogador.getGolsMarcados())
					.sum();
	}

	@Override
	public int getGolsMarcadosPorTime(List<Jogador> jogadores, String time) {
		return jogadores.stream()
					.filter(jogador -> jogador.getTimeAtual().equals(time))
					.mapToInt(Jogador::getGolsMarcados)
					.sum();
		
	}

	@Override
	public Jogador getJogadorMaisJovem(List<Jogador> jogadores) {
		//comparator sem method reference
		return jogadores.stream()
				.min((j1, j2) -> Integer.compare(j1.getIdade(), j2.getIdade()))
				.orElseThrow(NoSuchElementException::new);
				
	}

	@Override
	public Jogador buscarJogadorPeloNome(List<Jogador> jogadores, String nome) {
		return jogadores.stream()
				.filter(jogador -> jogador.getNome().equalsIgnoreCase(nome))
				.findFirst()
				.orElseThrow(NoSuchElementException::new);
	}

	@Override
	public Jogador buscarArtilheiroDoTime(List<Jogador> jogadores, String time) {
		return jogadores.stream()
				.filter(jogador -> jogador.getTimeAtual().equalsIgnoreCase(time))
				.max(Comparator.comparingInt(Jogador::getGolsMarcados))
				.orElseThrow(NoSuchElementException::new);
	}

	@Override
	public List<Jogador> getListaJogadoresTime(List<Jogador> jogadores, String time) {
		return jogadores.stream()
				.filter(jogador -> jogador.getTimeAtual().equalsIgnoreCase(time))
				.collect(Collectors.toList());
	}

	@Override
	public List<Jogador> getJogadoresOrdenadosPeloNome(List<Jogador> jogadores) {
		return jogadores.stream()
				.sorted(Comparator.comparing(Jogador::getNome))
				.collect(Collectors.toList());
	}

	@Override
	public List<Jogador> getJogadoresOrdenadosPeloTime(List<Jogador> jogadores) {
		return jogadores.stream()
				.sorted((j1, j2) -> j1.getTimeAtual().compareTo(j2.getTimeAtual()))
				.collect(Collectors.toList());
	}

	@Override
	public List<Jogador> getJogadoresOrdenadosPeloNumeroGols(List<Jogador> jogadores) {
		return jogadores.stream()
				.sorted(Comparator.comparingInt(Jogador::getGolsMarcados).reversed())
				.collect(Collectors.toList());
	}

	@Override
	public Jogador buscarArtilheiro(List<Jogador> jogadores) {
		return jogadores.stream()
				.max(Comparator.comparingInt(Jogador::getGolsMarcados))
				.orElseThrow(NoSuchElementException::new);
	}

	@Override
	public List<Jogador> getListaJogadoresComGols(List<Jogador> jogadores) {
		 jogadores.removeIf(jogador -> jogador.getGolsMarcados() < 1);
		 return jogadores;
	}

	@Override
	public Set<String> getListaTimes(List<Jogador> jogadores) {
		return jogadores.stream()
				.map(Jogador::getTimeAtual)
				.collect(Collectors.toSet());
	}

	@Override
	public Jogador buscarJogadorComMaisAssistencia(List<Jogador> jogadores) {
		return jogadores.stream()
				.max(Comparator.comparing(Jogador::getAssistencias))
				.orElseThrow(NoSuchElementException::new);
				
	}

	@Override
	public List<Jogador> getListaMaioresAssistentes(List<Jogador> jogadores) {
		return jogadores.stream()
				.sorted(Comparator.comparingInt(Jogador::getAssistencias)
						.reversed()
						.thenComparing(Jogador::getGolsMarcados))
				.limit(10)
				.collect(Collectors.toList());
	}

	@Override
	public Jogador buscarMaiorAssistenteDoTime(List<Jogador> jogadores, String time) {
		return jogadores.stream()
				.filter(jogador -> jogador.getTimeAtual().equalsIgnoreCase(time))
				.max(Comparator.comparingInt(Jogador::getAssistencias).reversed())
				.orElseThrow(NoSuchElementException::new);
	}

	@Override
	public List<Jogador> getListaDeAssistentes(List<Jogador> jogadores, long quantidade) {
		return jogadores.stream()
				.sorted(Comparator.comparingInt(Jogador::getAssistencias).reversed())
				.limit(quantidade)
				.collect(Collectors.toList());
	}

	@Override
	public int getQuantidadeAssitencias(List<Jogador> jogadores) {
		return jogadores.stream()
				.mapToInt(Jogador::getAssistencias)
				.sum();
	}

	@Override
	public int getAssitenciasPorTime(List<Jogador> jogadores, String time) {
		return jogadores.stream()
				.filter(jogador -> jogador.getTimeAtual().equalsIgnoreCase(time))
				.mapToInt(Jogador::getAssistencias)
				.sum();
	}

	@Override
	public List<Jogador> getListaAssistentesPeloNome(List<Jogador> jogadores, String nome) {
		return jogadores.stream()
				.filter(jogador -> jogador.getNome().contains(nome))
				.sorted(Comparator.comparingInt(Jogador::getAssistencias)
						.thenComparing(Comparator.comparing(Jogador::getGolsMarcados)))
				.collect(Collectors.toList());
	}

	@Override
	public List<Jogador> buscarJogadoresPelaQuantidadeGols(List<Jogador> jogadores, int gols) {
		return jogadores.stream()
				.filter(jogador -> jogador.getGolsMarcados() == gols)
				.sorted(Comparator.comparingInt(Jogador::getAssistencias)
						.thenComparing(Jogador::getNome))
				.collect(Collectors.toList());
	}

	@Override
	public List<Jogador> buscarJogadoresPelaQuantidadeAssistencias(List<Jogador> jogadores, int assistencias) {
		return jogadores.stream()
				.filter(jogador -> jogador.getAssistencias() == assistencias)
				.collect(Collectors.toList());
	}

	@Override
	public List<Jogador> buscarJogadoresPelaIdade(List<Jogador> jogadores, int idade) {
		return jogadores.stream()
				.filter(jogador -> jogador.getIdade() == idade)
				.collect(Collectors.toList());
	}

	@Override
	public List<Jogador> getListaJogadoresComMaisCartoesAmarelos(List<Jogador> jogadores) {
		return jogadores.stream()
				.sorted((j1, j2) -> Integer.compare(j2.getCartoesAmarelo(), j1.getCartoesAmarelo()))
				.limit(3)
				.collect(Collectors.toList());
	
	}

	@Override
	public double getMediaDeCartoesAmarelos(List<Jogador> jogadores) {
		return jogadores.stream()
				.mapToDouble(Jogador::getCartoesAmarelo)
				.average()
				.orElse(0);
	}

	@Override
	public int getQuantidadeCartoesAmarelos(List<Jogador> jogadores) {
		return jogadores.stream()
				.mapToInt(Jogador::getCartoesAmarelo)
				.sum();
	}

	@Override
	public Jogador getJogadorComMaisCartoes(List<Jogador> jogadores) {
		return jogadores.stream()
				.sorted(Comparator.comparing(Jogador::getCartoesAmarelo).reversed())
				.findFirst()
				.orElseThrow(NoSuchElementException::new);
	}

	@Override
	public int getCartoesAmarelosPorTime(List<Jogador> jogadores, String time) {
		return jogadores.stream()
				.filter(jogador -> jogador.getTimeAtual().equalsIgnoreCase(time))
				.mapToInt(Jogador::getCartoesAmarelo)
				.sum();
	}
	
}
