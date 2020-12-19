package br.com.devmos.stream.service;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Set;

import br.com.devmos.stream.model.Jogador;

public interface JogadorService {

	boolean verificarArquivoExiste(Path caminho);
	void imprimirJogadorMaisVelho(List<Jogador> jogadores);
	void imprimirListaDeJogadores(List<Jogador> jogadores);
	List<Jogador> getListaDeJogadores(Path caminho) throws IOException;
	List<Jogador> getListaArtilheiros(List<Jogador> jogadores);
	List<Jogador> getListaMaioresAssistentes(List<Jogador> jogadores);
	List<Jogador> getListaJogadoresTime(List<Jogador> jogadores, String time);
	List<Jogador> getJogadoresOrdenadosPeloNome(List<Jogador> jogadores);
	List<Jogador> getJogadoresOrdenadosPeloTime(List<Jogador> jogadores);
	List<Jogador> getJogadoresOrdenadosPeloNumeroGols(List<Jogador> jogadores);
	List<Jogador> getListaJogadoresComGols(List<Jogador> jogadores);
	List<Jogador> getListaDeAssistentes(List<Jogador> jogadores, long quantidade);
	List<Jogador> getListaJogadoresComMaisCartoesAmarelos(List<Jogador> jogadores);
	List<Jogador> getListaAssistentesPeloNome(List<Jogador> jogadores, String nome);
	List<Jogador> buscarJogadoresPelaQuantidadeGols(List<Jogador> jogadores, int gols);
	List<Jogador> ordenarJogadorPelosCartoesAmarelos(List<Jogador> jogadores);
	List<Jogador> buscarJogadoresPelaQuantidadeAssistencias(List<Jogador> jogadores, int assistencias);
	List<Jogador> buscarJogadoresPelaIdade(List<Jogador> jogadores, int idade);
	Set<String> getListaTimes(List<Jogador> jogadores);
	Jogador getJogadorMaisVelho(List<Jogador> jogadores);
	Jogador getJogadorMaisJovem(List<Jogador> jogadores);
	Jogador buscarJogadorPeloNome(List<Jogador> jogadores, String nome);
	Jogador buscarArtilheiroDoTime(List<Jogador> jogadores, String time);
	Jogador buscarArtilheiro(List<Jogador> jogadores);
	Jogador buscarJogadorComMaisAssistencia(List<Jogador> jogadores);
	Jogador buscarMaiorAssistenteDoTime(List<Jogador> jogadores, String time);
	Jogador getJogadorComMaisCartoes(List<Jogador> jogadores);
	Jogador getJogadorComMaisExpulsoes(List<Jogador> jogadores);
	Jogador getJogadorComMaisExpulsoesPorTime(List<Jogador> jogadores, String time);
	Jogador getJogadorComMenosCartoes(List<Jogador> jogadores);
	Jogador getJogadorComMenosCartoes(List<Jogador> jogadores, int cartoesVermelhos);
	double getMediaDasIdades(List<Jogador> jogadores);
	double getMediaDeGols(List<Jogador> jogadores);
	double getMediaDeCartoesAmarelos(List<Jogador> jogadores);
	int getQuantidadeGols(List<Jogador> jogadores);
	int getQuantidadeCartoesAmarelos(List<Jogador> jogadores);
	int getQuantidadeCartoesVermelhos(List<Jogador> jogadores);
	int getQuantidadeAssitencias(List<Jogador> jogadores);
	int getAssitenciasPorTime(List<Jogador> jogadores, String time);
	int getGolsMarcadosPorTime(List<Jogador> jogadores, String time);
	int getCartoesAmarelosPorTime(List<Jogador> jogadores, String time);
	int buscaCartoesAmarelosPorJogador(List<Jogador> jogadores, String nome);
	int buscaCartoeseVermelhosPorJogador(List<Jogador> jogadores, String nome);


}
