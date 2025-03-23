import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        System.out.println("🔵 Server is starting...");

        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            System.out.println("Server started. Waiting for client...");

            try (Socket socket = serverSocket.accept();
                 InputStream in = socket.getInputStream();
                 BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {

                System.out.println("Client connected. Receiving file...");

                // Define destination folder and file
                File destinationFolder = new File("D:/Langs/JavaCodes/ftpfs/received");
                if (!destinationFolder.exists()) {
                    destinationFolder.mkdirs();  // Create folder if it doesn't exist
                }

                File outputFile = new File(destinationFolder, "received_file.txt");
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        writer.write(line);
                        writer.newLine();
                    }
                }

                System.out.println("✅ File received successfully: " + outputFile.getAbsolutePath());
            }
        } catch (Exception e) {
            System.out.println("❌ Server Error: " + e.getMessage());
        }
    }
}
