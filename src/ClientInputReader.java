import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientInputReader extends Thread{

	Socket socket;
	private BufferedReader reader;
	
	public ClientInputReader(Socket socket) {
		this.socket = socket;
	}

	public void run() {
		try {
			reader = new BufferedReader(new InputStreamReader(
			        socket.getInputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			startListeningToInputs();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	private void startListeningToInputs() throws IOException {
		
		String message;
		while( (message = reader.readLine()) != null) {
			if ("x".equalsIgnoreCase(message)) {
				break;
			}
			System.out.println("Recieved message from server: " + message);
		}
		
	}
	
	
}
