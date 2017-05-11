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

    }

}
