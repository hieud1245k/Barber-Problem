package DistributeSystem.BallTransfer;

import java.io.Serializable;

class Ball implements Serializable {
	private static final long serialVersionUID = 2708721475697818329L;
	private int weight = 0;

	public Ball(int weight) {
		this.weight = weight;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
}
