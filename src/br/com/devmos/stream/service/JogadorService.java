package br.com.devmos.stream.service;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import br.com.devmos.stream.model.Jogador;

public interface JogadorService {

	boolean verificarArquivoExiste(Path caminho);
	void imprimirJogadorMaisVelho(List<Jogador> jogadores);
	List<Jogador> getListaDeJogadores(Path caminho) throws IOException;
	Jogador getJogadorMaisVelho(List<Jogador> jogadores);
	void imprimirListaDeJogadores(List<Jogador> jogadores);
	List<Jogador> getListaArtilheiros(List<Jogador> jogadores);
	double getMediaDasIdades(List<Jogador> jogadores);
	int getQuantidadeGols(List<Jogador> jogadores);
	double getMediaDeGols(List<Jogador> jogadores);
	int getGolsMarcadosPorTime(List<Jogador> jogadores, String time);
}
