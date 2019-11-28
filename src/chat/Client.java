package chat;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {
	public static void main(String[] args) throws Exception{
		
		InputStreamReader luongvao=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(luongvao);
		
		while (true) {
			Socket socket = new Socket("localhost",8979);
			System.out.print("Client: ");
			String send=br.readLine();
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			dos.writeUTF(send);
			
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			String receive = dis.readUTF();
			System.out.println("Server: "+receive);
		}
	}
	
}
