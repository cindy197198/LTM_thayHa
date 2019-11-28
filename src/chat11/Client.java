package chat11;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	private InetAddress host;
	private int port;
	public Client(InetAddress host, int port) {
		this.host = host;
		this.port = port;
	}
	private void ketNoi() throws IOException {
		Socket client=new Socket(host,port);
		DocSocket read=new DocSocket(client);
		read.start();
		
		GhiSocket write= new GhiSocket(client,"Client sent");
		Thread thread=new Thread(write);
		thread.start();
	}
	public static void main(String[] args) throws IOException {
		Client client=new Client(InetAddress.getLocalHost(),15579);
		client.ketNoi();
	}
}
