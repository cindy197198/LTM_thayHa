package dateTimeThread;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;


public class SocketThread extends Thread{
	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;
	public SocketThread(Socket sk) throws IOException {
		this.socket = sk;
		System.out.println("Serving: "+sk);
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(
		socket.getOutputStream())), true);
		start();
	}
	@Override
	public void run() { 
		try { 
			while (true){
				out.println(new Date().toString());
			} 
		} catch (Exception e) {}
		finally {
			try {socket.close(); } catch(IOException e) {}
		} 
	} 
}
