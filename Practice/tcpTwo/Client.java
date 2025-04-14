import java.io.*;
import java.net.*;

public class Client{
	public static void main(String a[]){
		try{Socket s = new Socket(InetAddress.getLocalHost(), 5050);
		// Send Message
		OutputStream o = s.getOutputStream();
		PrintStream p = new PrintStream(o);
		DataInputStream cliIn = new DataInputStream(System.in);
		// Recive Message
		InputStream i = s.getInputStream();
		DataInputStream serIn = new DataInputStream(i);
		
		String clientMes, serverMes;
		while(true){
			System.out.print("Client: ");
			clientMes = cliIn.readLine();
			p.println(clientMes);
			if("end".equals(clientMes)) break;
			System.out.print("Server: ");
			serverMes = serIn.readLine();
			System.out.println(serverMes);
		}
		}catch(IOException e){
			System.err.println(e);
		}
	}
}