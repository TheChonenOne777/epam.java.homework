package unit2.task6;


public class Main {

    public static void main(String[] args) {

        NuclearSubmarine nuclearSubmarine = new NuclearSubmarine();

        System.out.println("Try to speed up with engine off");
        nuclearSubmarine.speedUp(10);
        System.out.println("Is engine running: " + nuclearSubmarine.engine.isIfOn());

        System.out.println();

        System.out.println("Starting engine");
        nuclearSubmarine.engine.runEngine();
        System.out.println("Is engine running: " + nuclearSubmarine.engine.isIfOn());

        System.out.println();

        System.out.println("Speed up a submarine");
        nuclearSubmarine.speedUp(10);
        System.out.println("Submarine speed is " + nuclearSubmarine.getSpeed());


    }

}
