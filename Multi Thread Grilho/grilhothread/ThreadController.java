package grilhothread;

public class ThreadController extends Thread {
    float A[];
    float B[];
    float C[];
    int start, end;

    public ThreadController(float[] tempA, float[] tempB, float[] tempC, int s, int e) 
    {
        A = tempA;
        B = tempB;
        C = tempC;
        start = s;
        end = e;
    }

    @Override
    public void run() 
    {
        for (int i = start; i < end; i++)
            C[i] = A[i] + B[i]; 
    }

}
