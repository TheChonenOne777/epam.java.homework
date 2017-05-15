package unit2.task3;


import java.util.Objects;

public class Stapler extends Stationary {

    private String stapleSize;

    public Stapler(){
        name = "simple stapler";
        price = 30;
        color = "grey";
        stapleSize = "regular";
    }

    public Stapler(String name, int price, String color, String stapleSize) {
        super(name, price, color);
        this.stapleSize = stapleSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Stapler stapler = (Stapler) o;
        return Objects.equals(stapleSize, stapler.stapleSize);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), stapleSize);
    }

    @Override
    public String toString() {
        return "Stapler{" +
                "stapleSize='" + stapleSize + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", color='" + color + '\'' +
                '}';
    }
}
