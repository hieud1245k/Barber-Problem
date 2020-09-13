package DistributeSystem.BallTransfer;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;

public class Setup implements Remote {
	public static void main(String[] args) {
		try {
			PingServer pingServer = new PingServerImpl();
			Naming.rebind("rmi:localhost:5000/pingobject", pingServer);
			System.out.println("waiting for client request...");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
// javac *.java
// rmic Setup
// rmiregistry 5000
// java Setup
// java Client
