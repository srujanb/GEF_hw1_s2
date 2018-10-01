import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import processing.core.PApplet;

public class MyMsgServer extends PApplet{

	static int port = 6600;
	
	public static void main(String args[]) {
		PApplet.main("MyMsgServer");
//		System.out.println("Main method of server called");
		try {
			ServerSocket serverSocket = new ServerSocket(port);
			while(true) {
				System.out.println("About to accept clients");
				Socket clientSocket = serverSocket.accept();
				ClientManager clientManager = new ClientManager(clientSocket);
				clientManager.start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void settings() {
		size(1024,720);
	}
	
	public void setup() {
	
	}
	
	public void draw() {		
		
	}
	
}
