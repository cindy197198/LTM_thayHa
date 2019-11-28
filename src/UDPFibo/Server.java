package UDPFibo;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Date;

public class Server {

	public static void main(String[] args) throws Exception {
		// Gán cổng 9876 cho chương trình
		DatagramSocket serverSocket = new DatagramSocket(9879);
		//Tạo các mảng byte để chứa dữ liệu gửi và nhận
		System.out.println("Server is started");
		byte[] receiveData = new byte[1024];
		byte[] sendData = new byte[1024];
		boolean stop = false;
		while (!stop) {
			//Tạo gói rỗng để nhận dữ liệu từ client
			DatagramPacket receivePacket =new DatagramPacket(receiveData, receiveData.length);
			//Nhận dữ liệu từ client
			serverSocket.receive(receivePacket);
			//Lấy địa chỉ IP của máy client
			InetAddress IPAddress = receivePacket.getAddress();
			//Lấy port của chương trình client
			int port = receivePacket.getPort();

			int m = Integer.parseInt(new String(receivePacket.getData()).trim());
			System.out.println(checkFibo(m));
			if (checkFibo(m)!=-1) stop = true;
			sendData = checkFibo(m).toString().getBytes();
			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length,IPAddress,port);
			//Gửi dữ liệu lại cho client
			serverSocket.send(sendPacket);
		}
	}
	//kiểm tra số m có phải là Fibo không, nếu đúng trả về vị trí
		private static Integer checkFibo(int m) {
			int n=1,a=1,b=1;
			while (true) {
				if (m == a) return n;
				if (m == b) return n+1;
				if (a > m) return -1;
				a = a + b;
				b = a + b;
				n+=2;
			}
		}
}