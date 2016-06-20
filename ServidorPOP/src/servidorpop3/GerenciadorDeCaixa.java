package servidorpop3;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class GerenciadorDeCaixa {
	private String usuario;
	private ArrayList<String> emails = new ArrayList<String>();
	private LeitorDeArquivos leitor = new LeitorDeArquivos();

	GerenciadorDeCaixa(String usuario) {
		this.setUsuario(usuario);
		LeitorDeArquivos leitor = new LeitorDeArquivos();
		emails = leitor.lerArquivos(usuario);
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
		for(String linha : linhas) {
				conteudo += linha + "\n";
		}
		return conteudo;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public ArrayList<String> getEmails() {
		return emails;
	}

	public void setEmails(ArrayList<String> emails) {
		this.emails = emails;
	}
}
