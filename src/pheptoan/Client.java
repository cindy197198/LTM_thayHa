package pheptoan;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {
	public static void main(String[] args) throws Exception{
		Socket socket = new Socket("localhost",8981);
		
		InputStreamReader luongvao=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(luongvao);
		System.out.print("Nhập số a = ");
		double a = Double.parseDouble(br.readLine());
		System.out.print("Nhập số b = ");
		double b = Double.parseDouble(br.readLine());
		System.out.print("Nhập phép toán = ");
		String d = br.readLine();
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		dos.writeDouble(a);
		dos.writeDouble(b);
		dos.writeUTF(d);
		
		DataInputStream dis = new DataInputStream(socket.getInputStream());
		String result = dis.readUTF();
		System.out.println(result);
	}
	
}
