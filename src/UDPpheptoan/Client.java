package UDPpheptoan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {

	public static void main(String[] args) throws IOException {
		Integer m;
		String s;
		InputStreamReader luongvao = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(luongvao);
		DatagramSocket clientSocket = new DatagramSocket();// gán cổng
		InetAddress IPAddress = InetAddress.getByName("localhost");
		byte[] sendData = new byte[1024];
		byte[] receiveData = new byte[1024];
		// Nhập 2 số thực và 1 phép toán

		System.out.print("Nhập số a = ");
		Double a = Double.parseDouble(br.readLine());
		System.out.print("Nhập số b = ");
		Double b = Double.parseDouble(br.readLine());
		System.out.print("Nhập phép toán = ");
		String pt = br.readLine();
		String send = a+ " "+b+" "+pt;
		sendData= send.getBytes();
		// tạo datagram có nội dung yêu cầu loại dữ liệu để gửi cho server
		DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9880);
		clientSocket.send(sendPacket);
		// tạo datagram rỗng để nhận dữ liệu
		DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
		// nhận dữ liệu từ server
		clientSocket.receive(receivePacket);
		// lấy dữ liệu từ packet nhận được
		String rs = new String(receivePacket.getData()).trim();
		System.out.println(rs);
		clientSocket.close();

	}

}
