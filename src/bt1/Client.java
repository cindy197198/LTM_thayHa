package bt1;

import java.io.DataInputStream;
import java.net.Socket;

public class Client {
	public static void main(String[] args) throws Exception{
		Socket socket = new Socket("localhost",8977);
		DataInputStream dis = new DataInputStream(socket.getInputStream());
		String time = dis.readUTF();
		System.out.println(time);
	}
	
}
