package br.com.devmos.stream.model;

import java.util.List;
import java.util.stream.Collectors;

public class Time {
	
	private String nome;
	private List<Jogador> jogadores;
	private int golsMarcados;
	private int cartoesAmarelos;
	private int assistencias;
	private List<Jogador> jogadoresTime;
	
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
	
	public List<Jogador> getJogadoresTime() {
		return jogadoresTime;
	}
	
	public Time(String nome, List<Jogador> jogadores) {
		this.nome = nome;
		this.jogadores = jogadores;
		this.golsMarcados  = getQuantidadeDeGolsFeitos();
		this.cartoesAmarelos = getCartoesAmarelosTomados();
		this.assistencias = getAssistenciasFeitas();
		this.jogadoresTime = getJogadoresTimeAtual();
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
	
	private List<Jogador> getJogadoresTimeAtual() {
		return this.jogadores.stream()
				.filter(jogador -> jogador.getTimeAtual().equalsIgnoreCase(nome))
				.collect(Collectors.toList());
	}
}
