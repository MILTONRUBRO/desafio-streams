package br.com.devmos.streams.main;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import br.com.devmos.stream.model.Jogador;
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
			jogImpl.imprimirListaDeJogadores(listaDeJogadores);
		}
	}

}
