package fibo;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {
	public static void main(String[] args) throws Exception {
		InputStreamReader luongvao = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(luongvao);
		int m;
		while (true) {
			Socket socket = new Socket("localhost", 8981);

			while (true) {
				try {
					System.out.print("Nhập số nguyên dương m = ");
					m = Integer.parseInt(br.readLine());
					if (m>0) break;
					else System.out.println("Lỗi, vui lòng nhập số nguyên dương!");
				} catch (NumberFormatException e) {
					System.out.println("Lỗi, vui lòng nhập số nguyên!");
				}
			}

			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			dos.writeInt(m);

			DataInputStream dis = new DataInputStream(socket.getInputStream());
			int c = dis.readInt();
			if (c != -1) {
				System.out.println("Đây là số Fibo thứ " + c);
				break;
			}
		}

	}

}
