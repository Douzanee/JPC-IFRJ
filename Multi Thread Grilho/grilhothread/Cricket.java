package grilhothread;

import java.util.Random;

public class Cricket{
	public Cricket(String name) {
		this.cricketName = name;
	}
	
	String cricketName;
	int movementDistance;
	Random rand = new Random();
	int currentPosition = 0;
	int jumpCount = 0;
	boolean finalizou = false;
	
	public void Jump() {
		movementDistance = rand.nextInt(100);
		currentPosition += movementDistance;
		jumpCount += 1;
		System.out.println("O " + cricketName + " pulou " + movementDistance + "cm e já percorreu : " + currentPosition + "cm");
	}
}
