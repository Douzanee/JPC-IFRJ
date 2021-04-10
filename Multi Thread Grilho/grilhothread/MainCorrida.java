package grilhothread;

public class MainCorrida {
	
    public static void inicializa(float[] vet, int max) 
    {
        for (int i = 0; i <vet.length; i++)
            vet[i] = (float)(Math.random() * (float)max);
    }

    public static void processor(float[] A,float[] B, float[] C, int n) 
    {
        for (int i = 0; i < n; i++)
            C[i] = A[i] + B[i];
    }

    public static float somaVet ( float[] C, int n ) 
    { 
        float sum = 0;
        for (int i = 0; i< n; i++)
            sum += C[i];

        return sum;

    }

	public static void main(String[] args) {
        int size = 100;
        int nThreads = 4;
        int elemThread = size / nThreads;

        float [] vetA = new float[size];
        float [] vetB = new float [size];
        float [] vetC = new float [size];

        ThreadController threads[] = new ThreadController[nThreads];

        inicializa (vetA , 2);
        inicializa (vetB , 3);

        processor (vetA, vetB, vetC, size);

        System.out.println("versão sequencial soma");
        System.out.println("soma: "+ somaVet(vetC,size));

        for (int i = 0; i < nThreads; i++) 
        {
            int start = i * elemThread;
            int end = start + elemThread;

            threads[i] = new ThreadController(vetA,vetB,vetC, start, end);
            threads[i].start();
        }
        for (int i = 0; i < nThreads; i++) 
        {
          try 
          {
            threads[i].join();
          } 
          catch (InterruptedException e ) 
          {
              e.printStackTrace();
          }
        }

        System.out.println("versão paralela");
        System.out.println("soma: "+ somaVet(vetC,size));
	}

}
