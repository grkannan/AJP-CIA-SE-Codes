import java.net.*;
import java.io.*;

public class client {
    public static void main(String args[]) {
        try {
            Socket s = new Socket(InetAddress.getLocalHost(), 5000); // Use the correct class name

            PrintStream p = new PrintStream(s.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String st;
            System.out.println("Connected to server. Type messages (type 'end' to exit):");

            while (true) {
                st = br.readLine();
                p.println(st);
                if (st.equalsIgnoreCase("end")) break;
            }

            p.close();
            br.close();
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
