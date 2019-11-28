package dateTimeThread;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {
	public static void main(String[] args) throws Exception{
		Socket socket = new Socket("localhost",9999);
		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String time =  in.readLine(); 
		System.out.println(time);
	}
	
}
