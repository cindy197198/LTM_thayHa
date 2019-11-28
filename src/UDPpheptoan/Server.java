package UDPpheptoan;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Date;

public class Server {

	public static void main(String[] args) throws Exception {
		// Gán cổng 9876 cho chương trình
		DatagramSocket serverSocket = new DatagramSocket(9880);
		// Tạo các mảng byte để chứa dữ liệu gửi và nhận
		System.out.println("Server is started");
		byte[] receiveData = new byte[1024];
		byte[] sendData = new byte[1024];

		// Tạo gói rỗng để nhận dữ liệu từ client
		DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
		// Nhận dữ liệu từ client
		serverSocket.receive(receivePacket);
		// Lấy địa chỉ IP của máy client
		InetAddress IPAddress = receivePacket.getAddress();
		// Lấy port của chương trình client
		int port = receivePacket.getPort();
		
		String s = new String(receivePacket.getData()).trim();
		System.out.println(s);
		String[] arr = s.split(" ");
		double a = Double.parseDouble(arr[0]);
		double b = Double.parseDouble(arr[1]);
		int err = 0;
		switch (arr[2]) {
		case "+":
			a = a+b;
			break;
		case "-":
			a = a-b;
			break;
		case "*":
			a = a*b;
			break;
		case "/":
			if (b==0) err=2;
			else a = a/b;
			break;
		case "%":
			a = a%b;
			break;
		default:
			err = 1;
			break;
		}
		if (err==1) sendData = "Phép toán không đúng".getBytes();
		else if (err==2) sendData = "Lỗi chia cho 0".getBytes();
		else sendData = ("Kết quả = "+a).getBytes();
		DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
		// Gửi dữ liệu lại cho client
		serverSocket.send(sendPacket);
	}
}