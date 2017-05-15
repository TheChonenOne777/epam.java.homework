package unit2.task3;

/**
 * This abstact class is a parent for all stationary items.
 */

import java.util.Objects;

public abstract class Stationary {

    protected String name;
    protected int price;
    protected String color;

    public Stationary(){}

    public Stationary(String name, int price, String color){
        this.name = name;
        this.price = price;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) throws Exception {
        if(price >= 0) {
            this.price = price;
        } else {
            throw new Exception();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stationary that = (Stationary) o;
        return price == that.price &&
                Objects.equals(name, that.name) &&
                Objects.equals(color, that.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, color);
    }

    @Override
    public String toString() {
        return "Stationary{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", color='" + color + '\'' +
                '}';
    }
}
