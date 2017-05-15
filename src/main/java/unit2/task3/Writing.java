package unit2.task3;

import java.util.Objects;

/**
 * This abstract class unites all things for writing.
 */

public abstract class Writing extends Stationary implements writable {

    protected String inkColor;
    protected int writingResorceLevel;
    protected String material;
    protected float thickness;
    protected boolean ifWhipable;

    public Writing(){}

    public Writing(String name, int price, String color, String inkColor, int inkLevel, String material, float thickness) {
        super(name, price, color);
        this.inkColor = inkColor;
        this.writingResorceLevel = inkLevel;
        this.material = material;
        this.thickness = thickness;
    }

    public String getInkColor() {
        return inkColor;
    }

    public void setInkColor(String inkColor) {
        this.inkColor = inkColor;
    }

    public int getWritingResorceLevel() {
        return writingResorceLevel;
    }

    public void setWritingResorceLevel(int inklevel) {
        if(inklevel < 0) {
            inklevel = 0;
            System.out.println("ink level can only be between 0 and 100");
        }
        if(inklevel > 100){
            inklevel = 100;
            System.out.println("ink level can only be between 0 and 100");
        }
        this.writingResorceLevel = inklevel;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public float getThickness() {
        return thickness;
    }

    public void setThickness(float thickness) {
        this.thickness = thickness;
    }

    public boolean isIfWhipable() {
        return ifWhipable;
    }

    public void setIfWhipable(boolean ifWhipable) {
        this.ifWhipable = ifWhipable;
    }

    public void writeInformationOnPaper(Paper paper, String info){
        paper.getInformation().put(this, info);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Writing writing = (Writing) o;
        return writingResorceLevel == writing.writingResorceLevel &&
                Float.compare(writing.thickness, thickness) == 0 &&
                ifWhipable == writing.ifWhipable &&
                Objects.equals(inkColor, writing.inkColor) &&
                Objects.equals(material, writing.material);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), inkColor, writingResorceLevel, material, thickness, ifWhipable);
    }

    @Override
    public String toString() {
        return "Writing{" +
                "name='" + name + '\'' +
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
