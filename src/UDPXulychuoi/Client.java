package UDPXulychuoi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {

	public static void main(String[] args) throws IOException {
		DatagramSocket clientSocket = new DatagramSocket();//gán cổng
		InetAddress IPAddress = InetAddress.getByName("localhost");
		byte[] sendData = new byte[1024]; 
		byte[] receiveData = new byte[1024]; 
		//Nhập chuỗi cần xử lý
		InputStreamReader luongvao=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(luongvao);
		System.out.println("Nhập chuỗi cần xử lý: ");
		String s=br.readLine();
		
		sendData= s.getBytes();
		//tạo datagram có nội dung yêu cầu loại dữ liệu để gửi cho server
		DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length,IPAddress,9877);
		clientSocket.send(sendPacket);
		//tạo datagram rỗng để nhận dữ liệu
		DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
		//nhận dữ liệu từ server
		clientSocket.receive(receivePacket);
		//lấy dữ liệu từ packet nhận được
		String str = new String(receivePacket.getData());
		System.out.println(str);
		clientSocket.close();
	}

}
