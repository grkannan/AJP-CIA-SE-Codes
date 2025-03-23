import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;
public class eclient{
	public static void main(String args[]){
		try(Scanner sc = new Scanner(System.in);){
			System.out.print("Enter the code: ");
			int code = sc.nextInt();
			System.out.print("Enter previous reading:  ");
			int prev = sc.nextInt();
			System.out.print("Enter current reading: ");
			int curr = sc.nextInt();
			einter ei = (einter) Naming.lookup("rmi://localhost:5000/electric");
			electricity e = ei.getelec(code, curr - prev);
			double rs = e.calc();
			System.out.println("Electricity Bill: " + rs);
			sc.close();
		}catch(MalformedURLException | NotBoundException | RemoteException e){
			// e.printStackTrace();
			System.out.println(e);
		}
	}
}