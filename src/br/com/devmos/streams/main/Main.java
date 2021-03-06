package br.com.devmos.streams.main;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import br.com.devmos.stream.model.Jogador;
import br.com.devmos.stream.model.Time;
import br.com.devmos.stream.service.JogadorServiceImpl;

public class Main {

	public static void main(String[] args) throws IOException {
		
		JogadorServiceImpl jogImpl = new JogadorServiceImpl();
		String enderecoDir = "resources";
		String nomeArquivo = "dados_jogadores.txt";
		
		List<Jogador> listaDeJogadores = jogImpl.getListaDeJogadores(Paths.get(enderecoDir + "\\" + nomeArquivo));

		if (!jogImpl.verificarArquivoExiste(Paths.get(enderecoDir))) {
			System.out.println("Arquivo n�o encontrado");
		}else {
			Time santos = new Time("santos", listaDeJogadores);
			jogImpl.imprimirListaDeJogadores(listaDeJogadores);
			
			
			System.out.println(jogImpl.getListaArtilheiros(listaDeJogadores));
			
			System.out.println("A media das idades é " + jogImpl.getMediaDasIdades(listaDeJogadores));
			
			System.out.println("A media de gols é " + jogImpl.getMediaDeGols(listaDeJogadores));
			
			System.out.println("O tal de gols do Palmeiras é " + jogImpl.getGolsMarcadosPorTime(listaDeJogadores, "Palmeiras"));
			
			System.out.println("Buscando jogador " + jogImpl.buscarJogadorPeloNome(listaDeJogadores, "william"));
		
			System.out.println("Artilheiro da Chapecoense " + jogImpl.buscarArtilheiroDoTime(listaDeJogadores, "Chapecoense"));

			System.out.println("Jogadores do Cruzeiro " + jogImpl.getListaJogadoresTime(listaDeJogadores, "Cruzeiro"));
			
			System.out.println("Lista de Jogadores com mais assistência " + jogImpl.getListaMaioresAssistentes(listaDeJogadores));

			System.out.println("Maior Assistente do Santos " + jogImpl.buscarMaiorAssistenteDoTime(listaDeJogadores, "Santos"));

			System.out.println("Jogadores com 5 gols " + jogImpl.buscarJogadoresPelaQuantidadeGols(listaDeJogadores, 5));

			System.out.println("Jogadores com mais cartões amarelos " + jogImpl.getListaJogadoresComMaisCartoesAmarelos(listaDeJogadores));

			System.out.println("Santos marcou " + santos.getGolsMarcados() + " gols");
			
			System.out.println("Jogador com mais expulsões eh " + jogImpl.getJogadorComMaisExpulsoes(listaDeJogadores));
		}
	}

}
