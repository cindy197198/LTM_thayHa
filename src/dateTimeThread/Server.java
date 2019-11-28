package dateTimeThread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static final String IP = "127.0.0.1";
	public static final int PORT = 9999;
	public static void main(String[] args) throws Exception{
		int clientCount = 0;
		ServerSocket server = new ServerSocket(PORT);
		System.out.println("Server is started at port: " + PORT);
		try { 
			while(true) {
				Socket socket = server.accept();
				try { 
					clientCount++;
					new SocketThread(socket);
					System.out.println("Client " + clientCount + " đã kết nối...");
				} catch(IOException e) { socket.close(); }}}
				finally {
					server.close();
				} 
			} 
	}

