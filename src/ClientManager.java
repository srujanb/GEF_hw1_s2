import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class ClientManager extends Thread{

	private Socket clientSocket;

	public ClientManager(Socket clientSocket) {
		this.clientSocket = clientSocket;
	}
	
	public void run() {
		try {
			manageClientSocket();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void manageClientSocket() throws IOException {
		OutputStream outputStream = clientSocket.getOutputStream();
		InputStream inputStream = clientSocket.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		String clientMessage;
		
		while( (clientMessage = reader.readLine()) != null) {
			if ("x".equalsIgnoreCase(clientMessage)) {
				break;
			}
			String serverResponse = "You typed: " + clientMessage + "\n";
			outputStream.write(serverResponse.getBytes());
		}
		clientSocket.close();
	}
	
}
