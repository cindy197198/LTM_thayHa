package chat11;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	private int  port;

	public Server(int port) {
		this.port = port;
	}
	private void ketNoi() throws IOException {
		
		ServerSocket server=new ServerSocket(port);
		
		Socket socket =server.accept();
		DocSocket read=new DocSocket(socket);
		read.start();
		
		GhiSocket write= new GhiSocket(socket,"Server sent");
		
		Thread thread=new Thread(write);
		thread.start();
	}
	public static void main(String[] args) throws IOException {
		Server server=new Server(15579);
		server.ketNoi();
	}
	
}
