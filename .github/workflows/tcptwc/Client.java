import java.io.*;
import java.net.*;

public class Client {
    public static void main(String args[]) {
        System.out.println("Client is starting...");
        try {
            Socket s = new Socket(InetAddress.getLocalHost(), 5000);
            OutputStream o = s.getOutputStream();
            PrintWriter p = new PrintWriter(o, true);
            BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));
            InputStream i = s.getInputStream();
            BufferedReader serverInput = new BufferedReader(new InputStreamReader(i)) ;
            System.out.println("Connected to a server...");
            String s1, s2;
            while (true) {
                System.out.print("Client: ");
                s1 = consoleInput.readLine();
                p.println(s1);  // Send message to server

                if ("end".equalsIgnoreCase(s1)) break;

                s2 = serverInput.readLine();  // Receive message from server
                System.out.println("Server: " + s2);
            }

        } catch (Exception e) {
            System.out.println("Client Error: " + e.getMessage());
        }
    }
}
