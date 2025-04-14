import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class eimp extends UnicastRemoteObject implements einter {
    electricity e;

    // Constructor should have parentheses and a name
    public eimp() throws RemoteException {
        super();
    }

    // Implementing the remote method
    public electricity getelec(int c, int u) throws RemoteException {
        e = new electricity(c, u);
        return e;
    }
}
