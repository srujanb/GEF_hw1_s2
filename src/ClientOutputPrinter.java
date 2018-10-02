import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientOutputPrinter extends Thread {

	private Socket socket;
	private PrintWriter out;

	public ClientOutputPrinter(Socket socket) {
		// TODO Auto-generated constructor stub
		this.socket = socket;
	}
	
	public void run() {
		try {
			out = new PrintWriter(socket.getOutputStream(), true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		startPrintingOutput();
	}

	private void startPrintingOutput() {
		while(true) {
			out.println("Message from client");
	    	try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
