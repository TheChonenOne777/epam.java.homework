package unit2.task6;

import unit2.task7.*;

@PreWordForClass(
        author = "Vladimir Chertilov",
        dateCreated = "5/15/2017",
        isInGitHub = true
)
public class NuclearSubmarine {

    private int speed;
    protected NuclearSubmarineEngine engine;

    public NuclearSubmarine(){
        speed = 0;
        engine = new NuclearSubmarineEngine();
    }

    class NuclearSubmarineEngine{
        private boolean ifOn;

        private NuclearSubmarineEngine(){
            ifOn = false;
        }

        protected void runEngine(){
            ifOn = true;
        }

        public boolean isIfOn(){
            return ifOn;
        }
    }

    public int getSpeed(){
        return speed;
    }

    public void speedUp(int speedUp){
        if(engine.ifOn) {
            speed += speedUp;
        } else {
            System.out.println("Engine should be on!");
        }
    }

    public void slowDown(int speedDown){
        if(engine.ifOn) {
            speed -= speedDown;
        } else {
            System.out.println("Engine should be on!");
        }
    }

}
