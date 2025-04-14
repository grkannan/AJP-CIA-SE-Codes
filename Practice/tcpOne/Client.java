import java.io.*;
import java.net.*;

public class Client{
	public  static void main(String[] a){
		try{
		Socket s = new Socket(InetAddress.getLocalHost(), 5050);
		System.out.println("Connected to server...");
		
		OutputStream o = s.getOutputStream();
		PrintStream p = new PrintStream(o);
		
		DataInputStream dis = new DataInputStream(System.in);
		String send;
		while(true){
			System.out.print("Client: ");
			send = dis.readLine();
			p.println(send);
			if("end".equals(send)) break;
		}
		}catch (Exception e){
			System.err.println(e);
		}
	}
}