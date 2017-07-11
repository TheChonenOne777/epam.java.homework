package unit2.task2;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {


    public static void main(String[] args) {

        Item pen = new Item("Pen", 10);
        Item pencil = new Item("Pencil", 15);
        Item notebook = new Item("Notebook", 50);
        Item folder = new Item("Folder", 100);

        List<Item> itemList = new ArrayList<>(Arrays.asList(pen, pencil, notebook, folder));

        Desk desk1 = new Desk("Parker", itemList);
        Desk desk2 = new Desk("Smith", itemList);
        Desk desk3 = new Desk("Banks", itemList);

        System.out.println(desk1.countTotal());
        desk1.addItem(new Item("Sharpener", 5));
        System.out.println(desk1.countTotal());

    }
}
