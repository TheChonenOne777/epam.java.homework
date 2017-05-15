package unit2.task3;

import java.util.Objects;

public class Pen extends Writing {

    private boolean isAttachable;
    private final String type;

    public Pen() {
        name = "simple pen";
        price = 10;
        color = "blue";
        type = "ball";
        isAttachable = true;
        inkColor = "blue";
        writingResorceLevel = 100;
        material = "plastic";
        thickness = 1.0f;
        ifWhipable = false;
    }

    public Pen(String name, int price, String color, String writingResorceLevel, int inkLevel, String material, float thickness, boolean isAttachable, String type) {
        super(name, price, color, writingResorceLevel, inkLevel, material, thickness);
        this.isAttachable = isAttachable;
        this.type = type;
    }

    public boolean isAttachable() {
        return isAttachable;
    }

    public void setAttachable(boolean attachable) {
        isAttachable = attachable;
    }

    public String getType() {
        return type;
    }

    public void toWrite(String text) {
        System.out.println(text);
    }

    public void recharge(){
        writingResorceLevel = 100;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Pen pen = (Pen) o;
        return isAttachable == pen.isAttachable &&
                Objects.equals(type, pen.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), isAttachable, type);
    }

    @Override
    public String toString() {
        return "Pen{" +
                "isAttachable=" + isAttachable +
                ", type='" + type + '\'' +
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
