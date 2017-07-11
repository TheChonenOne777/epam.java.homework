package unit2.task2;

import org.junit.Before;
import org.junit.Test;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class DeskTest {

    Item pen;
    Item pencil;
    List<Item> itemList;
    Desk desk1;

    @Before
    public void init() {
        pen = new Item("Pen", 10);
        pencil = new Item("Pencil", 15);
        itemList = new ArrayList<>(Arrays.asList(pen, pencil));
        desk1 = new Desk();
    }


    @Test
    public void setItems() throws Exception {
        desk1.setItems(itemList);
        Object[] expected = itemList.toArray();
        Object[] actual = desk1.getItems().toArray();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void countTotal() throws Exception {
        assertEquals(0, desk1.countTotal());
        desk1.addItem(pen);
        desk1.addItem(pencil);
        assertEquals(25, desk1.countTotal());
    }

}