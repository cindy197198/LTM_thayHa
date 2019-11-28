package UDPXulychuoi;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Date;

public class Server {

	public static void main(String[] args) throws Exception {
		// Gán cổng 9876 cho chương trình
		DatagramSocket serverSocket = new DatagramSocket(9877);
		//Tạo các mảng byte để chứa dữ liệu gửi và nhận
		System.out.println("Server is started");
		byte[] receiveData = new byte[1024];
		byte[] sendData = new byte[1024];
		while (true) {
			//Tạo gói rỗng để nhận dữ liệu từ client
			DatagramPacket receivePacket =new DatagramPacket(receiveData, receiveData.length);
			//Nhận dữ liệu từ client
			serverSocket.receive(receivePacket);
			//Lấy địa chỉ IP của máy client
			InetAddress IPAddress = receivePacket.getAddress();
			//Lấy port của chương trình client
			int port = receivePacket.getPort();

			String request = new String(receivePacket.getData());
			request = request.trim();
			sendData = chuoiDao(request).getBytes();
			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length,IPAddress,port);
			//Gửi dữ liệu lại cho client
			serverSocket.send(sendPacket);
		}
	}

	private static String chuoiDao(String s) {
		String s1="";
		for (int i=0;i<s.length();i++)
			s1 = s.charAt(i)+s1;
		return s1;
	}

	private static String chuoiHoa(String s) {
		String s1="";
		for (int i=0;i<s.length();i++)
			if (s.charAt(i)>='a' && s.charAt(i)<='z') 
				s1+=(char)(s.charAt(i)-32);
			else s1+=s.charAt(i);
		return s1;
	}
	private static String nguyenAm(String s) {
		String na = "aeiouAEIOU";
		String result = "";
		for (int i=0;i<s.length();i++) {
			if (na.indexOf(s.charAt(i))>=0 && result.indexOf(s.charAt(i))<0)
				result+=s.charAt(i)+" ";
		}
		return result;
	}
}
