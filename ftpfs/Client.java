import java.net.*;
import java.io.*;

public class Client {
    public static void main(String a[]) {
        try (Socket s = new Socket(InetAddress.getLocalHost(), 5050)) {
            System.out.println("Connected to server...");

            DataInputStream dis = new DataInputStream(System.in); 
            InputStream ip = s.getInputStream();
            DataInputStream di = new DataInputStream(ip);
            OutputStream o = s.getOutputStream();
            PrintStream p = new PrintStream(o);

            System.out.print("Enter Filename: ");
            String fn = dis.readLine();
            p.println(fn);

            // Check first few bytes for error message
            byte[] buffer = new byte[255];
            int i = ip.read(buffer);
            String firstResponse = new String(buffer, 0, i);

            if (firstResponse.startsWith("FILE_NOT_FOUND")) {
                System.out.println("Server says: File not found.");
                return;
            }

            // If file exists, write to local file
            FileOutputStream fout = new FileOutputStream("received.txt");
            fout.write(buffer, 0, i); // Write first read

            while ((i = ip.read(buffer)) != -1) {
                fout.write(buffer, 0, i);
            }

            fout.close();
            System.out.println("Received.");
        } catch (IOException e) {
            System.err.println("Client Error: " + e);
        }
    }
}
