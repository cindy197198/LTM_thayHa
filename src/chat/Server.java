package chat;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws Exception{
		ServerSocket server = new ServerSocket(8979);
		InputStreamReader luongvao=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(luongvao);
		
		System.out.println("Server is started");
		while (true) {
			Socket socket = server.accept();
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			String receive = dis.readUTF();
			System.out.println("Client: "+receive);
			
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			System.out.print("Server: ");
			String send=br.readLine();
			dos.writeUTF(send);
			socket.close();
		}
	}

}
