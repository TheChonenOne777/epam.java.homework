package unit2.task3;


import java.util.Map;
import java.util.HashMap;
import java.util.Objects;

public class Paper extends Stationary {

    protected int length;
    protected int width;
    protected String format;
    protected int thickness;
    private Map<Writing, String> information;

    public Paper(){
        name = "paper";
        price = 1;
        color = "white";
        length = 297;
        width = 210;
        format = "a4";
        thickness = 90;
    }

    public Paper(String name, int price, String color, int length, int width, String format, int thickness) {
        super(name, price, color);
        this.length = length;
        this.width = width;
        this.format = format;
        this.thickness = thickness;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        if( length > 0) {
            this.length = length;
        } else {
            System.out.println("length cannot be a negative number");
        }
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        if( width > 0) {
            this.width = width;
        } else {
            System.out.println("width cannot be a negative number");
        }
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public int getThickness() {
        return thickness;
    }

    public void setThickness(int thickness) {
        if( thickness > 0) {
            this.thickness = thickness;
        } else {
            System.out.println("thickness cannot be a negative number");
        }
    }

    public Map<Writing, String> getInformation() {
        return information;
    }

    public void setInformation(Map<Writing, String> information) {
        this.information = information;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Paper paper = (Paper) o;
        return length == paper.length &&
                width == paper.width &&
                thickness == paper.thickness &&
                Objects.equals(format, paper.format);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), length, width, format, thickness);
    }

    @Override
    public String toString() {
        return "Paper{" +
                "length=" + length +
                ", width=" + width +
                ", format='" + format + '\'' +
                ", name='" + name + '\'' +
                ", thickness=" + thickness +
                ", price=" + price +
                ", color='" + color + '\'' +
                '}';
    }
}
