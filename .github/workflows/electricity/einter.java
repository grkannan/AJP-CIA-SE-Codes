import java.rmi.Remote;
import java.rmi.RemoteException;
 
public interface einter extends Remote{
	public electricity getelec(int c, int u) throws RemoteException;
}