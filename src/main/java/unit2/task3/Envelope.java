package unit2.task3;


import java.util.List;
import java.util.Objects;

public class Envelope extends Paper implements storable{

    private List<Paper> containPapiers;
    private boolean ifSealed;

    public Envelope(){
        name = "envlp";
        price = 15;
        color = "white";
        length = 15;
        width = 10;
        format = "c6";
        thickness = 120;
    }

    public Envelope(String name, int price, String color, int length, int width, String format, int thickness, boolean ifSealed) {
        super(name, price, color, length, width, format, thickness);
        this.containPapiers = containPapiers;
        this.ifSealed = ifSealed;
    }

    @Override
    public void toStore(Object object) {
        containPapiers.add((Paper)object);
    }

    public List<Paper> getContainPapiers() {
        return containPapiers;
    }

    public void setContainPapiers(List<Paper> containPapiers) {
        this.containPapiers = containPapiers;
    }

    public boolean isIfSealed() {
        return ifSealed;
    }

    public void setIfSealed(boolean ifSealed) {
        this.ifSealed = ifSealed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Envelope envelope = (Envelope) o;
        return ifSealed == envelope.ifSealed &&
                Objects.equals(containPapiers, envelope.containPapiers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), containPapiers, ifSealed);
    }

    @Override
    public String toString() {
        return "Envelope{" +
                "containPapiers=" + containPapiers +
                ", length=" + length +
                ", name='" + name + '\'' +
                ", width=" + width +
                ", ifSealed=" + ifSealed +
                ", price=" + price +
                ", format='" + format + '\'' +
                ", color='" + color + '\'' +
                ", thickness=" + thickness +
                '}';
    }
}
