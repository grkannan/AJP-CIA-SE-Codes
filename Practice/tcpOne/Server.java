import java.io.*;
import java.net.*;
public class Server{
	public static void main(String[] a){
		try{
		ServerSocket ss = new ServerSocket(5050);
		System.out.println("Server Started...");
		Socket s = ss.accept();
		System.out.println("Connected to client...");
		
		InputStream i = s.getInputStream();
		DataInputStream dis = new DataInputStream(i);
		String recive;
		while(true){
			System.out.print("Client: ");
			recive = dis.readLine();
			System.out.println(recive);
			if("end".equals(recive)) break;
		}
		}catch(Exception e){
			System.err.println(e);
		}
	}
}