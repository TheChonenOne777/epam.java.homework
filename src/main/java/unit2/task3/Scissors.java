package unit2.task3;


import java.util.Objects;

public class Scissors extends Stationary {

    private int currentSharpness;
    private final int initialSharpness;

    public Scissors(){
        name = "cutters";
        price = 35;
        color = "black";
        currentSharpness = 1000;
        initialSharpness = currentSharpness;
    }

    public Scissors(String name, int price, String color, int sharpness) {
        super(name, price, color);
        this.currentSharpness = sharpness;
        initialSharpness = sharpness;
    }


    public int getCurrentSharpness() {
        return currentSharpness;
    }

    public void cut(){
        if(currentSharpness > 0) {
            this.currentSharpness -= 1;
        } else {
            System.out.println("Scissors are not sharp engouh");
        }
    }

    public void sharpen(){
        this.currentSharpness = initialSharpness;
    }

    public int getInitialSharpness() {
        return initialSharpness;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Scissors scissors = (Scissors) o;
        return currentSharpness == scissors.currentSharpness &&
                initialSharpness == scissors.initialSharpness;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), currentSharpness, initialSharpness);
    }

    @Override
    public String toString() {
        return "Scissors{" +
                "currentSharpness=" + currentSharpness +
                ", initialSharpness=" + initialSharpness +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", color='" + color + '\'' +
                '}';
    }
}
