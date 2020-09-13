package DistributeSystem;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class HelloClient {
	public static void main(String args[]) {
		try {
			HelloItf helloItf = (HelloItf) Naming.lookup("rmi://localhost:5000/hello");
			System.out.println(helloItf.sayHello());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}