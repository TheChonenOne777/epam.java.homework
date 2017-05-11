package unit2.task2;

public class Item {

    private String name = "";
    private int price = 0;

    public Item(){};

    public Item(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) throws Exception {
        if(price > 0) {
            this.price = price;
        } else {
            throw new Exception();
        }
    }

}
