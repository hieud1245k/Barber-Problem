package DistributeSystem.BallTransfer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class PingServerImpl extends UnicastRemoteObject implements PingServer {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2624717246574208839L;

	public PingServerImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Ball ping(Ball b) throws RemoteException {
		System.out.println("Client send a ball objectweight " + b.getWeight());
		b.setWeight(b.getWeight() + 15);
		return b;
	}

}
