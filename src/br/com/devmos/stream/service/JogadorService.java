package br.com.devmos.stream.service;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import br.com.devmos.stream.model.Jogador;

public interface JogadorService {

	boolean verificarArquivoExiste(Path caminho);
	void imprimirJogadorMaisVelho(List<Jogador> jogadores);
	void imprimirListaDeJogadores(List<Jogador> jogadores);
	List<Jogador> getListaDeJogadores(Path caminho) throws IOException;
	List<Jogador> getListaArtilheiros(List<Jogador> jogadores);
	List<Jogador> getListaJogadoresTime(List<Jogador> jogadores, String time);
	List<Jogador> getJogadoresOrdenadosPeloNome(List<Jogador> jogadores);
	List<Jogador> getJogadoresOrdenadosPeloTime(List<Jogador> jogadores);
	List<Jogador> getJogadoresOrdenadosPeloNumeroGols(List<Jogador> jogadores);
	Jogador getJogadorMaisVelho(List<Jogador> jogadores);
	Jogador getJogadorMaisJovem(List<Jogador> jogadores);
	Jogador buscarJogadorPeloNome(List<Jogador> jogadores, String nome);
	Jogador buscarArtilheiroDoTime(List<Jogador> jogadores, String time);
	double getMediaDasIdades(List<Jogador> jogadores);
	double getMediaDeGols(List<Jogador> jogadores);
	int getQuantidadeGols(List<Jogador> jogadores);
	int getGolsMarcadosPorTime(List<Jogador> jogadores, String time);
}
