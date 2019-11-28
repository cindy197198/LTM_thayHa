package pheptoan;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Server {

	public static void main(String[] args) throws Exception{
		ServerSocket server = new ServerSocket(8981);
		System.out.println("Server is started");
		while (true) {
			Socket socket = server.accept();
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			double a = dis.readDouble();
			double b = dis.readDouble();
			String d = dis.readUTF();
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			
			double result = 0;
			int err = 0;
			switch (d) {
			case "+":
				result = a+b;
				break;
			case "-":
				result = a-b;
				break;
			case "*":
				result = a*b;
				break;
			case "/":
				if (b==0) err=2;
				else result = a/b;
				break;
			case "%":
				result = a%b;
				break;
			default:
				err = 1;
				break;
			}
			if (err==1)
				dos.writeUTF("Phép toán không đúng");
			else if (err==2) dos.writeUTF("Lỗi chia cho 0");
			else dos.writeUTF("Kết quả = "+result);
			socket.close();
		}
	}

}
