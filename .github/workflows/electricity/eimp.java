import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class eimp extends UnicastRemoteObject implements einter{
    public eimp()throws RemoteException{
        super();
    }
    @Override
    public electricity getelec(int c, int u) throws RemoteException{
        return  new electricity(c, u);
    }
}