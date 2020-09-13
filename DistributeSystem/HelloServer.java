package DistributeSystem;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;

@SuppressWarnings("deprecation")
public class HelloServer {
	public static void main(String args[]) {
//		System.setProperties(props);
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new RMISecurityManager());
		}
		try {
			Hello obj = new Hello();
			Naming.rebind("HelloObject", obj);
			System.out.println("HelloObject is registried");
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}
}