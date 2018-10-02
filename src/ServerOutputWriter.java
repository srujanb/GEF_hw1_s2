import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class ServerOutputWriter extends Thread{
	
	Socket socket;
	OutputStream outputStream;
	
	public ServerOutputWriter(Socket clientSocket) {
		this.socket = clientSocket;
	}

	public void run() {
		try {
			outputStream = socket.getOutputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("error 3");
			e.printStackTrace();
		}
		
		try {
			startWritingOutput();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("A User disconnected");
//			e.printStackTrace();
		}
	}

	private void startWritingOutput() throws IOException {
		while(true) {
			outputStream.write("Random message from server\n".getBytes());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
