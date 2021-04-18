package grilhothread;

public class Team {    
	public Team(int id) {
	this.id = id;
	}
	
	int id = 0;
    boolean winner = false;
    int totalJumps = 0;
    int totalTraversedDistance;

	public void Update(int distance) {
		totalJumps += 1;
		totalTraversedDistance += distance;
	}
	public void Finish() {

		System.out.println("Time " + (id+1) + " : Total de pulos: " + totalJumps + " Distância Percorrida: " + totalTraversedDistance + "cm");
		
	}
	public void ShowFinalWinner() {
		
		if(winner) {
			System.out.println("Time " + (id+1) + " foi o vencedor");
		}
	}
}