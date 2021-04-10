package grilhothread;

import java.util.Scanner;

public class MainCorrida {

    static int cricketsThatFinished = 0;
    
	public static void main(String[] args) {
        int cricketCount = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quantos grilos se juntarão a essa corrida? ");  
        cricketCount = scanner.nextInt();
        System.out.println("Grilos na corrida " + cricketCount);

        ThreadController threads[] = null;
        Cricket[] cricketMain = new Cricket[cricketCount];
        int finishLine = 200;
        
        for(int i = 0; i < cricketCount; i++) {
        	cricketMain[i] = new Cricket("Grilo_" + i, finishLine);
        }
        
        
        IniciarCorrida(cricketCount, threads, cricketMain, cricketsThatFinished);
        
        
	}
	
    public static void IniciarCorrida(int cricketsCount, ThreadController[] thread, Cricket[] cricket, int cricketsThatFinished) {
    	thread = new ThreadController[cricketsCount];
    	
    	for(int i = 0; i < cricketsCount; i++) 
    	{
    		thread[i] = new ThreadController(cricket[i]);
    		thread[i].start();
    	}

    	while(cricketsThatFinished < cricketsCount) {
    	Race(cricketsCount, thread, cricket);
    	
    	
    	}
    }

    public static void Race(int cricketsCount, ThreadController[] thread, Cricket[] cricket) {
    	
    		for(int i = 0; i < cricketsCount; i++) 
        	{

    			if(cricket[i].currentPosition >= cricket[i].finishLine) 
    			{
    				System.out.println("O " + cricket[i].cricketName +" alcançou a linha de chegada com "+ cricket[i].jumpCount + " pulos");
    				cricketsThatFinished ++;
    			}
    			else 
    			{
    				thread[i].run();
        		}
        	}
    	}
}