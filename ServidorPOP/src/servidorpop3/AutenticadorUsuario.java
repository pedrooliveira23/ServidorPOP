package servidorpop3;

import java.io.IOException;
import java.util.ArrayList;

public class AutenticadorUsuario {	
	public boolean autenticar(String usuario, String senha) {
		LeitorDeArquivos leitor = new LeitorDeArquivos();
		try {
			ArrayList<String> usuarios = leitor.lerArquivo("usuarios.txt");
			
			for(String u : usuarios) {
				String usuarioTemp = u.substring(0, u.indexOf('|')).toUpperCase();
				String senhaTemp = u.substring(u.indexOf('|')+1, u.length()).toUpperCase();
				
				if (usuario.equals(usuarioTemp) && senha.equals(senhaTemp)) {
					return true;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return false;
	}
}
