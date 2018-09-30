import java.net.Socket;

public class ClientManager extends Thread{

	private Socket clientSocket;

	public ClientManager(Socket clientSocket) {
		this.clientSocket = clientSocket;
	}
	public void run() {
		
	}
	
}
