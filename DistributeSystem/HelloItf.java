package DistributeSystem;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface HelloItf extends Remote {
	String sayHello() throws RemoteException;
}