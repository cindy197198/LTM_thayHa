package chat11;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

public class GhiSocket implements Runnable {
	private Socket socket;
	private String name;
	
	public GhiSocket(Socket socket,String name) {
		this.socket = socket;
		this.name=name;
	}
	//Nhập dữ liệu vào
	InputStreamReader luongvao=new InputStreamReader(System.in);
	BufferedReader br=new BufferedReader(luongvao);
	
	
	@Override
	public void run() {
		try {
			DataOutputStream dos=new DataOutputStream(socket.getOutputStream());
			
			while(true) {
				String sms=br.readLine();
				dos.writeUTF(name+":"+sms);
				dos.flush();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
