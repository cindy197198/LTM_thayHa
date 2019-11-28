package fibo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Server {

	public static void main(String[] args) throws Exception{
		ServerSocket server = new ServerSocket(8981);
		System.out.println("Server is started");
		//for (int i=1;i<=100;i++) System.out.println("Số Fibo thứ "+i+" = "+Fibo2(i));
		boolean stop  = false;
		while (!stop) {
			Socket socket = server.accept();
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			int m = dis.readInt();
			if (checkFibo2(m)!=-1) stop = true;
			
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());			
			dos.writeInt(checkFibo2(m));
			socket.close();
		}
	}
	//kiểm tra số m có phải là Fibo không, nếu đúng trả về vị trí
	private static int checkFibo2(int m) {
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
	
	private static int checkFibo(int m) {
		int n=1;
		while (m>=Fibo2(n)) {
			if (m==Fibo2(n)) return n;
			else n++;
		}
		return -1;
	}
	//tính số Fibo thứ n
	//cách 1: đệ quy
	private static long Fibo(int n) {
		if (n == 1 || n == 2) return 1;
		return Fibo(n-1)+ Fibo(n-2);
	}
	//cách 2: dùng công thức
	private static long Fibo2(int n) {
		return  (long) ((Math.pow(1+Math.sqrt(5), n) - Math.pow(1-Math.sqrt(5), n))/ (Math.pow(2, n)*Math.sqrt(5)));
	}
}
