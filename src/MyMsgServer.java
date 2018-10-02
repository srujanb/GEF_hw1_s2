import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import processing.core.PApplet;

public class MyMsgServer extends PApplet{

	static int port = 6600;
	
	public static void main(String args[]) {
		PApplet.main("MyMsgServer");
		System.out.println("Main method of server called");
		Runnable runnable = new Runnable() {
			public void run() {
				begin();
			}
		};
		new Thread(runnable).start();
	}
	
	public static void begin() {
		try {
			ServerSocket serverSocket = new ServerSocket(port);
			while(true) {
				System.out.println("About to accept clients");
				Socket clientSocket = serverSocket.accept();
				System.out.println("Accepted");
				Server server = new Server(clientSocket);
				server.start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void settings() {
//		System.out.println("Setup called");
		size(1024,720);
	}
	
	public void setup() {
//		System.out.println("Setup called");
	}
	
	public void draw() {		
//		System.out.println("Draw called");
	}
	
}
