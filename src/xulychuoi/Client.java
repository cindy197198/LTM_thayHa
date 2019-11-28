package xulychuoi;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {
	public static void main(String[] args) throws Exception{
		Socket socket = new Socket("localhost",8978);
		
		InputStreamReader luongvao=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(luongvao);
		System.out.println("Nhập chuỗi cần xử lý: ");
		String s=br.readLine();
		
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		dos.writeUTF(s);
		
		DataInputStream dis = new DataInputStream(socket.getInputStream());
		String result = dis.readUTF();
		System.out.println(result);
	}
	
}
