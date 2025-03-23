import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class eserver {
    public static void main(String args[]) {
        try {
            // Start the RMI registry only if it's not already running
            try {
                LocateRegistry.createRegistry(5000);
                System.out.println("RMI Registry started on port 5000.");
            } catch (RemoteException e) {
                System.out.println("RMI Registry already running on port 5000.");
            }

            // Create and bind remote object
            eimp ei = new eimp();
            Naming.rebind("rmi://localhost:5000/electric", ei);
            System.out.println("RMI Server is running.");
        } catch (MalformedURLException | RemoteException e) {
            System.out.println(e);
        }
    }
}
