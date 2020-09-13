package DistributeSystem.BallTransfer;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Client {
	public static void main(String[] args) {
		Ball ball = new Ball(15);
		try {
			PingServer pingServer = (PingServer) Naming.lookup("rmi:localhost:5000/pingobject");
			System.out.println("Ball weight before send to server "+ ball.getWeight());
			Ball anotherBall = pingServer.ping(ball);
			System.out.println("Ball weight after send to server "+ball.getWeight());
			System.out.println("Ball weight return by server "+anotherBall.getWeight());
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
