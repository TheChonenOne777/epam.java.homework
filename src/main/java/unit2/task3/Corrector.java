package unit2.task3;


import java.util.Objects;

public class Corrector extends Erasure {

    private int dryTime;

    public Corrector(){
        name = "kat";
        price = 20;
        color = "white";
        dryTime = 10;
    }

    public Corrector(String name, int price, String color, int dryTime) {
        this.name = name;
        this.price = price;
        this.color = color;
        this.dryTime = dryTime;
    }

    public int getDryTime() {
        return dryTime;
    }

    public void setDryTime(int dryTime) {
        this.dryTime = dryTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Corrector corrector = (Corrector) o;
        return dryTime == corrector.dryTime;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), dryTime);
    }

    @Override
    public String toString() {
        return "Corrector{" +
                "dryTime=" + dryTime +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", color='" + color + '\'' +
                '}';
    }
}
