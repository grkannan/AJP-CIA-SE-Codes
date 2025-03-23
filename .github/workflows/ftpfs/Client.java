import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        System.out.println("🟢 Client is starting...");

        try (Socket socket = new Socket(InetAddress.getLocalHost(), 5000);
             OutputStream out = socket.getOutputStream();
             PrintWriter writer = new PrintWriter(out, true);
             BufferedReader fileReader = new BufferedReader(new FileReader("D:/Langs/JavaCodes/ftpfs/source/sample.txt"))) {

            System.out.println("✅ Connected to server. Sending file...");

            String line;
            while ((line = fileReader.readLine()) != null) {
                writer.println(line);
            }

            System.out.println("✅ File sent successfully.");
        } catch (Exception e) {
            System.out.println("❌ Client Error: " + e.getMessage());
        }
    }
}
