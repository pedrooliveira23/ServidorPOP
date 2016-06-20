package servidorpop3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LeitorDeArquivos {
	public ArrayList<String> lerArquivo(String nome) throws IOException {
		ArrayList<String> conteudo = new ArrayList<String>();
		
		FileReader arq = new FileReader(nome);
	    BufferedReader lerArq = new BufferedReader(arq);
	    String linha = lerArq.readLine();
		conteudo.add(linha);
		
		while (linha != null) {
			linha = lerArq.readLine();
			conteudo.add(linha);
		}
		
		lerArq.close();
		return conteudo;
	}
	
	public ArrayList<String> listarArquivos(String nome) {
		ArrayList<String> conteudo = new ArrayList<String>();
		File[] newEmails = new File("/home/" + nome.toLowerCase() + "/Maildir/new/").listFiles();
		File[] curEmails = new File("/home/" + nome.toLowerCase() + "/Maildir/cur/").listFiles();
		File[] tmpEmails = new File("/home/" + nome.toLowerCase() + "/Maildir/tmp/").listFiles();
		
		for(File e : newEmails) {
			conteudo.add(e.getAbsolutePath());
		}
		for(File e : curEmails) {
			conteudo.add(e.getAbsolutePath());
		}
		for(File e : tmpEmails) {
			conteudo.add(e.getAbsolutePath());
		}
		
		return conteudo;
	}
}
