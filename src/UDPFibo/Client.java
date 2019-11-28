package UDPFibo;

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
		InputStreamReader luongvao=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(luongvao);
		while (true) {
			DatagramSocket clientSocket = new DatagramSocket();//gán cổng
			InetAddress IPAddress = InetAddress.getByName("localhost");
			byte[] sendData = new byte[1024]; 
			byte[] receiveData = new byte[1024]; 
			//Nhập số
			while (true) {
				try {
					System.out.print("Nhập số nguyên dương m = ");
					s = br.readLine();
					m = Integer.parseInt(s);
					if (m>0) break;
					else System.out.println("Lỗi, vui lòng nhập số nguyên dương!");
				} catch (NumberFormatException e) {
					System.out.println("Lỗi, vui lòng nhập số nguyên!");
				}
			}
			sendData= s.getBytes();
			//tạo datagram có nội dung yêu cầu loại dữ liệu để gửi cho server
			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length,IPAddress,9879);
			clientSocket.send(sendPacket);
			//tạo datagram rỗng để nhận dữ liệu
			DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
			//nhận dữ liệu từ server
			clientSocket.receive(receivePacket);
			//lấy dữ liệu từ packet nhận được
			String c = new String(receivePacket.getData()).trim();
			if (!c.equals("-1")) {
				System.out.println("Đây là số Fibo thứ " + c);
				break;
			}
			clientSocket.close();
		}
		
	}

}
