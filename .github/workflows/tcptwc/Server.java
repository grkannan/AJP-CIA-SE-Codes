import java.io.*;
import java.net.*;

public class Server {
    public static void main(String args[]) {
        System.out.println("Server is starting...");
        try {
            ServerSocket ss = new ServerSocket(5000);
            System.out.println("Server is started. Waiting for a client...");
            Socket sk = ss.accept();
            OutputStream o = sk.getOutputStream();
            PrintWriter p = new PrintWriter(o, true);
            InputStream i = sk.getInputStream();
            BufferedReader clientInput = new BufferedReader(new InputStreamReader(i));
            BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));

            String s1, s2;
            while (true) {
                s1 = clientInput.readLine();  // Receive message from client
                System.out.println("Client: " + s1);

                if ("end".equalsIgnoreCase(s1)) break;

                System.out.print("Server: ");
                s2 = consoleInput.readLine();
                p.println(s2);  // Send response to client
            }

        } catch (Exception e) {
            System.out.println("Server Error: " + e.getMessage());
        }
    }
}
