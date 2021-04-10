package grilhothread;

import java.util.Random;

public class Cricket{	
	public int finishLine;
	public Cricket(String name, int finishLine) {
		this.cricketName = name;
		this.finishLine = finishLine;	
	}
	
	String cricketName;
	int movementDistance;
	Random rand = new Random();
	int currentPosition = 0;
	int jumpCount = 0;
	
	public void Jump() {
		movementDistance = rand.nextInt(50);
		currentPosition += movementDistance;
		jumpCount += 1;
		System.out.println("O " + cricketName + " pulou " + movementDistance + "cm e já percorreu : " + currentPosition + "cm");
	}
}
