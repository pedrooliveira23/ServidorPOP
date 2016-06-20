package servidorpop3;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class GerenciadorDeCaixa {
	private ArrayList<String> emails = new ArrayList<String>();
	private LeitorDeArquivos leitor = new LeitorDeArquivos();

	GerenciadorDeCaixa(String usuario) {
		LeitorDeArquivos leitor = new LeitorDeArquivos();
		emails = leitor.listarArquivos(usuario);
	}

	public String listarEmails() {
		String conteudo = "";
		for(int i = 0; i <= emails.size()-1; i++) {
			conteudo += (i+1) + " "+new File(emails.get(i)).length()+"\n";
		}
		return conteudo;
	}
	
	public String lerEmail(String i) throws NumberFormatException, IOException {
		ArrayList<String> linhas = leitor.lerArquivo(emails.get(Integer.parseInt(i) - 1));
		String conteudo = "";
		for(int l = 0; l < linhas.size() - 1; l++) {
			String linha = linhas.get(l);
			conteudo += linha + "\n";
		}
		conteudo += "\n";
		return conteudo;
	}
}
