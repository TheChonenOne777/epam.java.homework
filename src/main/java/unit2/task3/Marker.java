package unit2.task3;

import java.util.Objects;

public class Marker extends Writing {

    private int opacity;

    public Marker(){
        name = "simple pen";
        price = 10;
        color = "blue";
        opacity = 100;
        ifWhipable = false;
        inkColor = "black";
        writingResorceLevel = 100;
        material = "plastic";
        thickness = 2.0f;
    }

    public Marker(String name, int price, String color, String inkColor, int inkLevel, String material, float thickness, int opacity, boolean ifWhipable) {
        super(name, price, color, inkColor, inkLevel, material, thickness);
        this.opacity = opacity;
    }

    public int getOpacity() {
        return opacity;
    }

    public void setOpacity(int opacity) {
        if(opacity < 0) {
            opacity = 0;
            System.out.println("opacity can only be between 0 and 100");
        }
        if(opacity > 100){
            opacity = 100;
            System.out.println("opacity can only be between 0 and 100");
        }
        this.opacity = opacity;
    }


    public void toWrite(String text) {
        System.out.println(text);;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Marker marker = (Marker) o;
        return opacity == marker.opacity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), opacity);
    }

    @Override
    public String toString() {
        return "Marker{" +
                "opacity=" + opacity +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", inkColor='" + inkColor + '\'' +
                ", color='" + color + '\'' +
                ", writingResorceLevel=" + writingResorceLevel +
                ", material='" + material + '\'' +
                ", thickness=" + thickness +
                '}';
    }
}
