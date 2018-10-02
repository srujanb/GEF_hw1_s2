import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Client extends Thread{
	
	Socket socket;
	private BufferedReader reader;
	private PrintWriter out;
	private OutputStream outputStream;
	
	public Client(Socket socket) {
		// TODO Auto-generated constructor stub
		this.socket = socket;
	}

	public void run() {
		try {
			maintainConnection();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void maintainConnection() throws IOException {
		reader = new BufferedReader(new InputStreamReader(
	            socket.getInputStream()));
	    out = new PrintWriter(socket.getOutputStream(), true);
	    outputStream = socket.getOutputStream();
	    
	    while (true) {
	    	System.out.println("Sending message to server");
//	    	outputStream.write("Message from client".getBytes());
	    	out.println("Message from client");
	    	try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    }
	    
	}

	
}
