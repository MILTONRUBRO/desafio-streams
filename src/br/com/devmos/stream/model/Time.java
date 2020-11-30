package br.com.devmos.stream.model;

import java.util.List;

public class Time {
	
	private String nome;
	private List<Jogador> jogadores;
	private int golsMarcados;
	private int cartoesAmarelos;
	private int assistencias;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Jogador> getJogadores() {
		return jogadores;
	}
	public void setJogadores(List<Jogador> jogadores) {
		this.jogadores = jogadores;
	}
	
	public int getGolsMarcados() {
		return golsMarcados;
	}

	public int getCartoesAmarelos() {
		return cartoesAmarelos;
	}
	
	public int getAssistencias() {
		return assistencias;
	}
	public Time(String nome, List<Jogador> jogadores) {
		this.nome = nome;
		this.jogadores = jogadores;
		this.golsMarcados  = getQuantidadeDeGolsFeitos();
		this.cartoesAmarelos = getCartoesAmarelosTomados();
		this.assistencias = getAssistenciasFeitas();
	}
	
	private int getQuantidadeDeGolsFeitos() {
		return this.jogadores.stream()
				.filter(jogador -> jogador.getTimeAtual().equalsIgnoreCase(this.nome))
				.mapToInt(Jogador::getGolsMarcados)
				.sum();
	}
	
	private int getCartoesAmarelosTomados() {
		return this.jogadores.stream()
				.filter(jogador -> jogador.getTimeAtual().equalsIgnoreCase(this.nome))
				.mapToInt(Jogador::getCartoesAmarelo)
				.sum();
	}
	
	private int getAssistenciasFeitas() {
		return this.jogadores.stream()
				.filter(jogador -> jogador.getTimeAtual().equalsIgnoreCase(this.nome))
				.mapToInt(Jogador::getAssistencias)
				.sum();
	}
}
