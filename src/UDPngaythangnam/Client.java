package UDPngaythangnam;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {

	public static void main(String[] args) throws IOException {
		DatagramSocket clientSocket = new DatagramSocket();//gán cổng
		InetAddress IPAddress = InetAddress.getByName("localhost");
		byte[] sendData = new byte[1024]; 
		byte[] receiveData = new byte[1024]; 
		sendData= "getDate".getBytes();
		//tạo datagram có nội dung yêu cầu loại dữ liệu để gửi cho server
		DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length,IPAddress,9876);
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
