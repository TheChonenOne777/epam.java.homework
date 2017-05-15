package unit2.task3;


public class Sharpener extends Stationary {

    private int cutDiameter;

    public Sharpener(){
        name = "sharpener";
        price = 10;
        color = "black";
        cutDiameter = 7;
    }

    public Sharpener(String name, int price, String color, int cutDiameter) {
        super(name, price, color);
        this.cutDiameter = cutDiameter;
    }

    public void sharpenPencil(Pencil pencil){
        pencil.setWritingResorceLevel(pencil.getWritingResorceLevel() - 1);
        pencil.setIfSharpened(true);
    }

    public int getCutDiameter() {
        return cutDiameter;
    }

    public void setCutDiameter(int cutDiameter) {
        this.cutDiameter = cutDiameter;
    }


}
