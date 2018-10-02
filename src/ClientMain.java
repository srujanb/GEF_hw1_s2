import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientMain {

	static int port = 6600;
	
	public static void main(String[] args) {
		try {
			connectToServer();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void connectToServer() throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		String serverAddress = "localhost";
		Socket socket = new Socket(serverAddress,port);
		Client client = new Client(socket);
		client.start();
	}

}
