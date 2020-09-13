package DistributeSystem;

import java.rmi.server.UnicastRemoteObject;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class Hello extends UnicastRemoteObject implements HelloItf {
	private static final long serialVersionUID = 1L;

	public Hello() throws RemoteException {
		super();
	}

	@Override
	public String sayHello() throws RemoteException {
		return "Hello world!";
	}
	public static void main(String[] args) {
		try {
			Naming.rebind("rmi://localhost:5000/hello", new Hello());
			System.out.println("Server da san sang");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}