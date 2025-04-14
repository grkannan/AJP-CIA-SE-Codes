import java.io.*;
import java.net.*;

public class Server{
	public static void main(String a[]){
		try{ServerSocket ss = new ServerSocket(5050);
		System.out.println("Server started...");
		Socket s = ss.accept();
		System.out.println("Connected to client");
		// send message
		OutputStream o = s.getOutputStream(); 
		PrintStream p = new PrintStream(o);
		DataInputStream serIn = new DataInputStream(System.in);
		// recive message
		InputStream i = s.getInputStream();
		DataInputStream cliIn = new DataInputStream(i);
		
		String clientMessage, serverMessage;
		while(true){
			System.out.print("Client: ");
			clientMessage = cliIn.readLine();
			System.out.println(clientMessage);
			if("end".equalsIgnoreCase(clientMessage)) break;
			System.out.print("Server: ");
			serverMessage = serIn.readLine();
			p.println(serverMessage);
			
		}
		}catch(IOException e){
			System.out.println(e);
		}
	}
}