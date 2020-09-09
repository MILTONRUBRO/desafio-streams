package br.com.devmos.stream.tests;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.devmos.stream.model.Jogador;
import br.com.devmos.stream.service.JogadorServiceImpl;

public class JogadorTest {
	
	JogadorServiceImpl jogImpl;
	List<Jogador>  listaJogadores;
	
	@Before
	public void init() {
		jogImpl = new JogadorServiceImpl();
		
		listaJogadores = Arrays.asList(new Jogador("Messi", "Meia", 32, "Barcelona", 765),
				new Jogador("Zidane", "Atacante", 40, "Real Madrid", 345),
				new Jogador("Kross", "Meia", 18, "Barcelona", 124));
	}

	@Test
	public void testeImprimirJogadorMaisVelho() {
		List<Jogador> jogadores = Arrays.asList(new Jogador("Pele", "Atacante", 67, "Santos", 1000),
				new Jogador("Ronaldo", "Atacante", 30, "Real Madrid", 609),
				new Jogador("Ronaldinho", "Meia", 28, "Barcelona", 478));

		jogImpl.imprimirJogadorMaisVelho(jogadores);
	}

	@Test
	public void testeGetJogadorMaisVelho() {
		Jogador j1 = new Jogador("Romario", "Atacante", 33, "Vasco", 33);
		Jogador j2 = new Jogador("Edmundo", "Atacante", 25, "Palmeiras", 21);
		Jogador j3 = new Jogador("Cristiano Ronaldo", "Atacante", 21, "Manchester", 23);

		List<Jogador> jogadores = Arrays.asList(j1, j2, j3);
		
		Assert.assertEquals(j1, jogImpl.getJogadorMaisVelho(jogadores));

	}
	
	@Test
	public void testeMediaDaIdadeDosJogadores() {
		
		double mediaDasIdades = jogImpl.getMediaDasIdades(listaJogadores);
		
		Assert.assertEquals(30, mediaDasIdades, 0.001);
	}

}
