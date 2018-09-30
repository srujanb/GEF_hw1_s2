import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import processing.core.PApplet;

public class MyMsgServer extends PApplet{

	int port = 6600;
	ServerSocket serverSocket;
	
	public static void main(String args[]) {
		PApplet.main("MyMsgServer");
	}
	
	public void settings() {
		size(1024,720);
	}
	
	public void setup() {
		try {
			serverSocket = new ServerSocket(port);
		} catch (IOException e) {
			System.out.println("Error creating instance of serversocket.");
			e.printStackTrace();
		}
	}
	
	public void draw() {
		System.out.println("About to accept clients");
		try {
			Socket clientSocket = serverSocket.accept();
			System.out.println("Accepted");
			OutputStream outputStream = clientSocket.getOutputStream();
			outputStream.write("From the output stream".getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
