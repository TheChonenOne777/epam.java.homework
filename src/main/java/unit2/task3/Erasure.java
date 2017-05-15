package unit2.task3;


import java.util.Map;
import java.util.Objects;

public class Erasure extends Stationary implements erasable {

    private String hardness;
    private String size;

    public Erasure(){
        name = "Elephant";
        price = 5;
        color = "white";
        hardness = "soft";
        size = "ordinary";
    }

    public Erasure(String name, int price, String color, String hardness, String size) {
        super(name, price, color);
        this.hardness = hardness;
        this.size = size;
    }

    public String getHardness() {
        return hardness;
    }

    public void setHardness(String hardness) {
        this.hardness = hardness;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void erase(Paper paper, String str) {
        for(Map.Entry<Writing, String> pair : paper.getInformation().entrySet()){

            if(pair.getKey().ifWhipable && pair.getValue().equals(str)){

                paper.getInformation().remove(pair.getKey());

            }

        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Erasure erasure = (Erasure) o;
        return Objects.equals(hardness, erasure.hardness) &&
                Objects.equals(size, erasure.size);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), hardness, size);
    }

    @Override
    public String toString() {
        return "Erasure{" +
                "hardness='" + hardness + '\'' +
                ", size='" + size + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", color='" + color + '\'' +
                '}';
    }
}
