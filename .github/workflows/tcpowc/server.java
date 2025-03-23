import java.net.*;
import java.io.*;

public class server {
    public static void main(String args[]) {
        try {
            ServerSocket ss = new ServerSocket(5000);  // Use a valid port
            System.out.println("Server is running... Waiting for a client.");

            Socket sk = ss.accept();
            System.out.println("Client connected.");

            BufferedReader br = new BufferedReader(new InputStreamReader(sk.getInputStream()));

            String s;
            while (true) {
                s = br.readLine();  // Use readLine()
                if (s == null || s.equalsIgnoreCase("end")) break;
                System.out.println("Client: " + s);
            }

            System.out.println("Client disconnected.");
            br.close();
            sk.close();
            ss.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
