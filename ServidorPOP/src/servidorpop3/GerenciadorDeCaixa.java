package servidorpop3;

import java.io.File;
import java.util.ArrayList;

public class GerenciadorDeCaixa {
	private String usuario;
	private ArrayList<String> emails = new ArrayList<String>();

	GerenciadorDeCaixa(String usuario) {
		this.setUsuario(usuario);
	}

	

	public String listarEmails() {
		LeitorDeArquivos leitor = new LeitorDeArquivos();
		ArrayList<String> emails = leitor.lerArquivos(usuario);
		String conteudo = "";
		for(int i = 0; i <= emails.size()-1; i++) {
			conteudo += (i+1) + " "+new File(emails.get(i)).length()+"\n";
		}
		return conteudo;
	}
	
	public String lerEmail(String i) {
		LeitorDeArquivos leitor = new LeitorDeArquivos();
		String conteudo = leitor.lerArquivo(emails.get(Integer.parseInt(i) - 1));
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
