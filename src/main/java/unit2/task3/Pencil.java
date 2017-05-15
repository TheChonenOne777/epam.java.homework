package unit2.task3;

import java.util.Objects;

public class Pencil extends Writing {

    private int length;
    private final String hardness;
    boolean ifSharpened;
    private int diameter;
    private final boolean ifAutomatic;

    public Pencil() {
        name = "simple pen";
        price = 10;
        color = "blue";
        length = 15;
        ifSharpened = true;
        hardness = "B2";
        inkColor = "blue";
        writingResorceLevel = 100;
        material = "plastic";
        thickness = 1.0f;
        ifWhipable = true;
        diameter = 7;
        ifAutomatic = false;
    }

    public Pencil(String name, int price, String color, String inkColor, int inkLevel, String material, float thickness, int length, String hardness, boolean ifSharpened, int diameter, boolean ifAutomatic) {
        super(name, price, color, inkColor, inkLevel, material, thickness);
        this.length = length;
        this.hardness = hardness;
        this.ifSharpened = ifSharpened;
        this.diameter = diameter;
        this.ifAutomatic = ifAutomatic;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        if (length > 0) {
            this.length = length;
        } else {
            System.out.println("Pencil length must be above zero");
        }
    }

    public String getHardness() {
        return hardness;
    }

    public boolean isIfSharpened() {
        return ifSharpened;
    }

    public void setIfSharpened(boolean ifSharpened) {
        this.ifSharpened = ifSharpened;
    }

    public int getDiameter() {
        return diameter;
    }

    public boolean isIfAutomatic() {
        return ifAutomatic;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    public void setWritingResorceLevel(int inklevel) {
        if(this.isIfAutomatic()){
            super.setWritingResorceLevel(100);
        } else {
            System.out.println("Non-automatic pencil cannot be restored.");
        }
    }

    public void toWrite(String text) {
        System.out.println(text);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Pencil pencil = (Pencil) o;
        return length == pencil.length &&
                ifSharpened == pencil.ifSharpened &&
                diameter == pencil.diameter &&
                Objects.equals(hardness, pencil.hardness);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), length, hardness, ifSharpened, diameter);
    }

    @Override
    public String toString() {
        return "Pencil{" +
                "length=" + length +
                ", hardness='" + hardness + '\'' +
                ", ifSharpened=" + ifSharpened +
                ", name='" + name + '\'' +
                ", diameter=" + diameter +
                ", price=" + price +
                ", inkColor='" + inkColor + '\'' +
                ", color='" + color + '\'' +
                ", writingResorceLevel=" + writingResorceLevel +
                ", material='" + material + '\'' +
                ", thickness=" + thickness +
                ", ifWhipable=" + ifWhipable +
                '}';
    }
}
