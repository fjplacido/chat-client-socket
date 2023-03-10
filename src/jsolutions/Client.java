package jsolutions;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {

	private static final String HOST_NAME = "NCC17278";
	private static final int SERVER_PORT = 9005;

	public static void main(String[] args) {

		for (int i = 0; i < 5; i++) {

			try (Socket socket = new Socket(HOST_NAME, SERVER_PORT)) {

				String messageToClient = "Mensagem do cliente número: " + i;
				System.out.println("[SENT TO SERVER]: " + messageToClient);

				try (DataOutputStream data = new DataOutputStream(socket.getOutputStream())) {
					data.writeInt(i);
					data.writeUTF(messageToClient);
				}

			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

	}

}
