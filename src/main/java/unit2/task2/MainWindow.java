package unit2.task2;


import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainWindow {


    private JPanel mainPanel;
    private JTextField deskOwnerTextField;
    private JButton addDeskButton;
    private JTextField itemNameTextField;
    private JTextField itemPriceTextField;
    private JButton addItemButton;
    private JButton removeItemButton;
    private JScrollPane listOfDesks;
    private JScrollPane listOfItems;

    public static void main(String[] args) {

        Item pen = new Item("Pen", 10);
        Item pencil = new Item("Pencil", 15);
        Item notebook = new Item("Notebook", 50);
        Item folder = new Item("Folder", 100);

        List<Item> itemList = new ArrayList<Item>(Arrays.asList(pen, pencil, notebook, folder));

        Desk desk1 = new Desk("Parker", itemList);
        Desk desk2 = new Desk("Smith", itemList);
        Desk desk3 = new Desk("Banks", itemList);

    }
}
