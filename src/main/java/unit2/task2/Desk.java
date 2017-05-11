package unit2.task2;

import java.util.*;

public class Desk {

    private final int id;
    private String owner;
    private List<Item> items;

    private static int counterId;

    public Desk(){
        counterId++;
        id = counterId;
        owner = "";
        items = new ArrayList<Item>();
    }

    public Desk(String owner){
        this();
        this.owner = owner;
    }

    public Desk(String owner, List<Item> items){
        this(owner);
        this.items = items;
    }

    public int getId() {
        return id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }


    public void addItem(Item item){
        items.add(item);
    }

    public void removeItem(Item item){
        items.remove(item);
    }

    public int countTotal(){
        int total = 0;

        for(Item item : items){
            total += item.getPrice();
        }

        return total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Desk desk = (Desk) o;

        if (id != desk.id) return false;
        if (owner != null ? !owner.equals(desk.owner) : desk.owner != null) return false;
        return items != null ? items.equals(desk.items) : desk.items == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (owner != null ? owner.hashCode() : 0);
        result = 31 * result + (items != null ? items.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Desk{" +
                "id=" + id +
                ", owner='" + owner + '\'' +
                ", items=" + items +
                '}';
    }
}
