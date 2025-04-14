import java.rmi.Naming;
import java.io.*;

public class eclient {
    public static void main(String a[]) {
        try {
            DataInputStream dis = new DataInputStream(System.in);
            int code, cur, prev;

            System.out.print("Enter Code: ");
            code = Integer.parseInt(dis.readLine());

            System.out.print("Enter Previous Reading: ");
            prev = Integer.parseInt(dis.readLine());

            System.out.print("Enter Current Reading: ");
            cur = Integer.parseInt(dis.readLine());

            // Lookup RMI object using full URL
            einter ei = (einter) Naming.lookup("rmi://localhost:2025/electric");

            // Call remote method
            electricity e = ei.getelec(code, cur - prev);
            double rs = e.calc(); // assumes calc() is defined in electricity class

            System.out.println("Electricity Bill: " + rs);

        } catch (Exception e) {
            System.out.println("Client error: " + e);
        }
    }
}
