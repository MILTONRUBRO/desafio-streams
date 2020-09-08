package br.com.devmos.stream.model;

public class Jogador {

	private String nome;
	private String posicao;
	private int idade;
	private String timeAtual;
	private int golsMarcados;

	public String getNome() {
		return nome;
	}

	public String getPosicao() {
		return posicao;
	}

	public int getIdade() {
		return idade;
	}

	public String getTimeAtual() {
		return timeAtual;
	}

	public int getGolsMarcados() {
		return golsMarcados;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setPosicao(String posicao) {
		this.posicao = posicao;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public void setTimeAtual(String timeAtual) {
		this.timeAtual = timeAtual;
	}

	public void setGolsMarcados(int golsMarcados) {
		this.golsMarcados = golsMarcados;
	}

	public Jogador(String nome, String posicao, int idade, String timeAtual, int golsMarcados) {
		this.nome = nome;
		this.posicao = posicao;
		this.idade = idade;
		this.timeAtual = timeAtual;
		this.golsMarcados = golsMarcados;

	}

	public Jogador() {

	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + golsMarcados;
		result = prime * result + idade;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((posicao == null) ? 0 : posicao.hashCode());
		result = prime * result + ((timeAtual == null) ? 0 : timeAtual.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jogador other = (Jogador) obj;
		if (golsMarcados != other.golsMarcados)
			return false;
		if (idade != other.idade)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (posicao == null) {
			if (other.posicao != null)
				return false;
		} else if (!posicao.equals(other.posicao))
			return false;
		if (timeAtual == null) {
			if (other.timeAtual != null)
				return false;
		} else if (!timeAtual.equals(other.timeAtual))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Jogador [nome=" + nome + ", posicao=" + posicao + ", idade=" + idade + ", timeAtual=" + timeAtual
				+ ", golsMarcados=" + golsMarcados + "]";
	}
}