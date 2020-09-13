package DistributeSystem.BallTransfer;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PingServer extends Remote {
	public Ball ping(Ball b) throws RemoteException;
}
