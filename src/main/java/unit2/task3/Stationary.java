package unit2.task3;


public abstract class Stationary {

    protected String name;
    protected int price;
    protected String color;

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

}
