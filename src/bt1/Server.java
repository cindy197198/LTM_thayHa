package bt1;

import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Server {

	public static void main(String[] args) throws Exception{
		ServerSocket server = new ServerSocket(8977);
		System.out.println("Server is started");
		while (true) {
			Socket socket = server.accept();
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			String time = new Date().toString();
			dos.writeUTF("Server trả lại ngày giờ: "+time);
			socket.close();
		}
	}

}
