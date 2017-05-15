package unit2.task3;

import java.util.Objects;

public class Ruler extends Stationary {

    private int lenght;
    private String material;
    private String measureUnit;

    public Ruler(){
        name = "ruler";
        price = 20;
        color = "transparent";
        lenght = 30;
        material = "plastic";
        measureUnit = "sm";
    }

    public Ruler(String name, int price, String color, int lenght, String material, String measureUnit){
        super(name, price, color);
        this.lenght = lenght;
        this.material = material;
        this.measureUnit = measureUnit;
    }

    public int getLenght() {
        return lenght;
    }

    public void setLenght(int lenght) {
        if(lenght > 0){
            this.lenght = lenght;
        } else {
            System.out.println("Length cannot be negative");
        }
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getMeasureUnit() {
        return measureUnit;
    }

    public void setMeasureUnit(String measureUnit) {
        this.measureUnit = measureUnit;
    }

    @Override
    public String toString() {
        return "Ruler{" +
                "lenght=" + lenght +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", material='" + material + '\'' +
                ", color='" + color + '\'' +
                ", measureUnit='" + measureUnit + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Ruler ruler = (Ruler) o;
        return lenght == ruler.lenght &&
                Objects.equals(material, ruler.material) &&
                Objects.equals(measureUnit, ruler.measureUnit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), lenght, material, measureUnit);
    }
}
