import java.rmi.Naming;

public class eserver {
    public static void main(String[] a) {
		try {
            einter ei = new eimp();
            Naming.rebind("rmi://localhost:2025/electric", ei);
			String[] names = Naming.list("rmi://localhost:2025/");
			for (String name : names) {
				System.out.println("Bound: " + name);
			}
            System.out.println("RMI Server is running and bound as 'electric'.");
        } catch (Exception e) {
            System.out.println("Server error: " + e);
        }
    }
}
