package xulychuoi;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Server {

	public static void main(String[] args) throws Exception{
		ServerSocket server = new ServerSocket(8978);
		System.out.println("Server is started");
		while (true) {
			Socket socket = server.accept();
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			String s = dis.readUTF();
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			String result = chuoiHoa(s);
			dos.writeUTF("Chuỗi hoa: "+chuoiHoa(s)+
					"\nChuỗi thường: "+chuoiThuong(s)+
					"\nChuỗi vừa hoa vừa thường: "+chuoiHoaThuong(s)+
					"\nSố từ: "+soTu(s)+
					"\nCác nguyên âm có trong chuỗi: "+nguyenAm(s)+
					"\nChuỗi có chữ cái đầu tiên của mỗi từ là kí tự hoa: "+kiTuHoaMoiTu(s));
			socket.close();
		}
	}

	private static String kiTuHoaMoiTu(String s) {
		String s1 = "";
		s = chuoiThuong(s);
		System.out.println(s);
		s = ' '+s;
		for (int i=1;i<s.length();i++)
			if (s.charAt(i-1)==' '&&s.charAt(i)!=' ') s1 += (s.charAt(i)>='a' && s.charAt(i)<='z')?(char)(s.charAt(i)-32):s.charAt(i);
			else s1 += s.charAt(i);
		return s1.substring(0);
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

	private static int soTu(String s) {
		int dem=0;
		s=s.trim();
		for (int i=0;i<s.length()-1;i++)
			if (s.charAt(i)==' '&&s.charAt(i+1)!=' ') dem++;
		return dem+1;
	}

	private static String chuoiHoaThuong(String s) {
		String s1="";
		for (int i=0;i<s.length();i++)
			if (s.charAt(i)>='a' && s.charAt(i)<='z') 
				s1+=(char)(s.charAt(i)-32);
			else if (s.charAt(i)>='A' && s.charAt(i)<='Z') 
				s1+=(char)(s.charAt(i)+32);
			else s1+=s.charAt(i);
		return s1;
	}

	private static String chuoiThuong(String s) {
		String s1="";
		for (int i=0;i<s.length();i++)
			if (s.charAt(i)>='A' && s.charAt(i)<='Z') 
				s1+=(char)(s.charAt(i)+32);
			else s1+=s.charAt(i);
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

}
