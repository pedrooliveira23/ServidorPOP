package servidorpop3;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServidorPop3 {

	public static void main(String[] args) {
		try {
			ServerSocket socketRecepcao = new ServerSocket(1100);
			Socket socketConexao = socketRecepcao.accept();
			InputStream doCliente = socketConexao.getInputStream();
			OutputStream paraCliente = socketConexao.getOutputStream();
			byte[] buffer;
			String comando = "nada";
			String user = null;
			String pass = null;
			boolean autenticado = false;
			paraCliente.write("Bem-vindo!.\n".getBytes());
			while (!comando.equals("QUIT ")) {
				buffer = new byte[1024];
				doCliente.read(buffer);
				comando = new String(buffer).toUpperCase().trim() + " ";
				switch (comando.substring(0, comando.indexOf(' '))) {
				case "USER":
					user = comando.substring(comando.indexOf(' ') + 1, comando.length()-1);
					pass = null;
					paraCliente.write("Agora a senha.\n".getBytes());
					break;
				case "PASS":
					pass = comando.substring(comando.indexOf(' ') + 1, comando.length()-1);
					AutenticadorUsuario autenticador = new AutenticadorUsuario();
					if (autenticador.autenticar(user, pass)) {
						paraCliente.write(new String("O que deseja, " + user + "?\n").getBytes());
						autenticado = true;
					} else {
						paraCliente.write("Não consegui te identificar, desculpe.\n".getBytes());
					}
					break;
				case "LIST":
					if (autenticado) {
						GerenciadorDeCaixa caixa = new GerenciadorDeCaixa(user);
						paraCliente.write(caixa.listarEmails().getBytes());
					}
					break;
				case "QUIT":
					paraCliente.write("Até mais!\n".getBytes());
					break;
				}
			}
			socketConexao.close();
			socketRecepcao.close();
		} catch (

		Exception e) {
			e.printStackTrace();
		}

	}

}
