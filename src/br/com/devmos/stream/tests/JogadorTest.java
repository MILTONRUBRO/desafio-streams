package br.com.devmos.stream.tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.devmos.stream.model.Jogador;
import br.com.devmos.stream.service.JogadorServiceImpl;

public class JogadorTest {

	JogadorServiceImpl jogImpl;
	List<Jogador> listaJogadores;
	List<Jogador> listaJogadoresOrdenadaPeloTime;

	@Before
	public void init() {
		jogImpl = new JogadorServiceImpl();

		listaJogadores = Arrays.asList(new Jogador("Messi", "Meia", 32, "Barcelona", 765),
				new Jogador("Zidane", "Atacante", 40, "Real Madrid", 345),
				new Jogador("Kross", "Meia", 18, "Barcelona", 124));
		
		listaJogadoresOrdenadaPeloTime = Arrays.asList(new Jogador("Messi", "Meia", 32, "Barcelona", 765),
				new Jogador("Kross", "Meia", 18, "Barcelona", 124),
				new Jogador("Zidane", "Atacante", 40, "Real Madrid", 345));
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

	@Test
	public void testeQuantidadeDeGolsMarcados() {
		int total = jogImpl.getQuantidadeGols(listaJogadores);

		Assert.assertEquals(1234, total);
	}

	@Test
	public void testeMediaDeGolsMarcados() {
		double media = jogImpl.getMediaDeGols(listaJogadores);

		Assert.assertEquals(411.333333, media, 0.001);
	}
	
	@Test
	public void testeQuantidadeDeGolsPorTime() {
		int total = jogImpl.getGolsMarcadosPorTime(listaJogadores, "Barcelona");
		int total2 = jogImpl.getGolsMarcadosPorTime(listaJogadores, "");

		
		Assert.assertEquals(889, total);
		Assert.assertEquals(0, total2);
		
	}
	
	@Test
	public void testeGetJogadorMaisNovo() {
		Jogador jogador = new Jogador("Kross", "Meia", 18, "Barcelona", 124);
		Jogador j1 = jogImpl.getJogadorMaisJovem(listaJogadores);
		
		Assert.assertEquals(jogador, j1);
	}
	
	@Test
	public void testeBuscarJogadorPeloNome() {
		Jogador j1 = new Jogador("Messi", "Meia", 32, "Barcelona", 765);

		Jogador j2 = jogImpl.buscarJogadorPeloNome(listaJogadores, "messi");
		
		Assert.assertEquals(j1, j2);
	}
	
	@Test
	public void testaBuscaDoArtilheiroDoTime() {
		Jogador j1 = new Jogador("Messi", "Meia", 32, "Barcelona", 765);
		Jogador j2 = jogImpl.buscarArtilheiroDoTime(listaJogadores, "Barcelona");
		
		Assert.assertEquals(j1, j2);

	}
	
	@Test
	public void testaListaDejogadoresPorTime() {
		
		List<Jogador> jogadoresTeste = Arrays.asList(new Jogador("Messi", "Meia", 32, "Barcelona", 765),
				new Jogador("Kross", "Meia", 18, "Barcelona", 124));
		
		List<Jogador> jogadores = jogImpl.getListaJogadoresTime(listaJogadores, "Barcelona");
		
		Assert.assertEquals(jogadoresTeste, jogadores);
	}
	
	@Test
	public void testaListaDeJogadoresOrdenadaPeloNome() {
		
		List<Jogador> listaJogadoresOrdenada =   Arrays.asList(new Jogador("Kross", "Meia", 18, "Barcelona", 124),
				new Jogador("Messi", "Meia", 32, "Barcelona", 765),
				new Jogador("Zidane", "Atacante", 40, "Real Madrid", 345));
		
		Assert.assertEquals(listaJogadoresOrdenada, jogImpl.getJogadoresOrdenadosPeloNome(listaJogadoresOrdenada));
		
	}
	
	@Test
	public void testaListaDeJogadoresOrganizadaPeloTime() {
		
		List<Jogador> jogadores = jogImpl.getJogadoresOrdenadosPeloTime(listaJogadores);
		
		Assert.assertEquals(listaJogadoresOrdenadaPeloTime, jogadores);
	}
	
	@Test
	public void testaListaDeJogadoresOrganizadaPeloNumeroDeGols() {
		List<Jogador> jogadoresOrganizadosNumeroGols = jogImpl.getJogadoresOrdenadosPeloNumeroGols(listaJogadores);
		
		//minha lista já esta organizada
		Assert.assertEquals(listaJogadores, jogadoresOrganizadosNumeroGols);
	}
	
	@Test
	public void testaBuscarArtilheiro() {
		Jogador j1 = new Jogador("Messi", "Meia", 32, "Barcelona", 765);
		Jogador j2 = jogImpl.buscarArtilheiro(listaJogadores);
		
		
		Assert.assertEquals(j1, j2);

	}
	
	@Test
	public void testaListaDeJogadoresComPeloMenosUmGol() {
		
		List<Jogador> jogadoresTeste =  new ArrayList<Jogador>(){{
				add(new Jogador("Messi", "Meia", 32, "Barcelona", 765));
				add(new Jogador("Zidane", "Atacante", 40, "Real Madrid", 345));
				add(new Jogador("Kross", "Meia", 18, "Barcelona", 124));
				add(new Jogador("Suarez", "Atacante", 33, "Atletico", 0));
				add(new Jogador("Tiao", "Atacante", 33, "Atletico", 0));

				
		}};
		
		List<Jogador> jogadores = jogImpl.getListaJogadoresComGols(jogadoresTeste);

		
		Assert.assertEquals(listaJogadores, jogadores);

	}
	
	@Test
	public void testaListaTimes() {
		Set<String> listaTimes = jogImpl.getListaTimes(listaJogadores);
		Set<String> listaTimesAtual =  new HashSet<>();
		listaTimesAtual.add("Barcelona");
		listaTimesAtual.add("Real Madrid");
		
		Assert.assertEquals(listaTimesAtual, listaTimes);
	}

}
