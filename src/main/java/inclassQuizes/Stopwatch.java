package inclassQuizes;


public class Stopwatch {

    private long startTime;
    private long stopTime;

    private boolean running = false;

    public void startStopwatch(){

        running = true;
        startTime = System.nanoTime();

    }

    public void stopStopwatch(){

        running = false;
        stopTime = System.nanoTime();

    }

    public long getElapsedTime(){

        long elapsed;

        if(running) elapsed = System.nanoTime() - startTime;

        else elapsed = stopTime - startTime;

        return elapsed;

    }
}

