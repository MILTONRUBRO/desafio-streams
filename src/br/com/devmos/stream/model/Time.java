package br.com.devmos.stream.model;

import java.util.List;

public class Time {
	
	private String nome;
	private List<Jogador> jogadores;
	private int golsMarcados;
	
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

	public Time(String nome, List<Jogador> jogadores) {
		this.nome = nome;
		this.jogadores = jogadores;
		this.golsMarcados  = getQuantidadeDeGolsFeitos();
	}
	
	private int getQuantidadeDeGolsFeitos() {
		return this.jogadores.stream()
				.filter(jogador -> jogador.getTimeAtual().equalsIgnoreCase(this.nome))
				.mapToInt(Jogador::getGolsMarcados)
				.sum();
	}
}
