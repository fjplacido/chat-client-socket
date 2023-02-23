package jsolutions;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

public class Client {

	private Socket cliente;

	public static void main(String[] args) {
		new Client().initClient();
	}

	private void initClient() {
		try {
			cliente = new Socket("127.0.0.1", 3322);
			PrintStream saida = new PrintStream(cliente.getOutputStream());
			saida.println("Mensagem do cliente");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

}
