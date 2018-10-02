import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class ServerInputReader extends Thread{
	
	Socket socket;
	InputStream inputStream;
	OutputStream outputStream;
	
	public ServerInputReader(Socket clientSocket) {
		this.socket = clientSocket;
	}

	public void run() {
		try {
			inputStream = socket.getInputStream();
			outputStream = socket.getOutputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("error 1");
			e.printStackTrace();
		}
		try {
			startListeningToInputs();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			System.out.println("error 2");
			e1.printStackTrace();
		}
		
	}

	private void startListeningToInputs() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		String clientMessage = null;
		while( (clientMessage = reader.readLine()) != null) {
			if ("x".equalsIgnoreCase(clientMessage)) {
				break;
			}
			String serverResponse = "You sent: " + clientMessage + "\n";
			outputStream.write(serverResponse.getBytes());
			System.out.println("Recieved message: " + clientMessage);
		}
		
	}

}
