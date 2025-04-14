import java.io.*;
import java.net.*;

public class Server {
    public static void main(String a[]) {
        try (ServerSocket ss = new ServerSocket(5050)) {
            System.out.println("Waiting for client.");
            Socket s = ss.accept();
            System.out.println("Connected to client.");

            InputStream ip = s.getInputStream();
            DataInputStream dis = new DataInputStream(ip);
            OutputStream o = s.getOutputStream();

            String fname = dis.readLine(); // Receiving from client
            File f = new File(fname);

            if (!f.exists()) {
                System.out.println("File not found.");
                o.write("FILE_NOT_FOUND".getBytes()); // Send error message
                s.close();
                return;
            }

            System.out.println("Transferring...");
            FileInputStream fis = new FileInputStream(f);
            byte[] buffer = new byte[255];
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                o.write(buffer, 0, bytesRead); // Write actual bytes read
            }

            fis.close();
            s.close();
            System.out.println("File sent successfully.");
        } catch (IOException e) {
            System.err.println("Server Error: " + e);
        }
    }
}
