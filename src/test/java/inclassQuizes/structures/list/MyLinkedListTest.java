package inclassQuizes.structures.list;


import org.junit.Test;
import static org.junit.Assert.*;

public class MyLinkedListTest {

    MyLinkedList<String> ll = new MyLinkedList<>();

    @Test
    public void add() throws Exception {
        ll.add("one");
        ll.add("two");
        ll.add("three");
        ll.add("four");
        ll.add("five");
        assertEquals(5, ll.size());
        assertEquals("one", ll.first.getElement());
        assertEquals("two", ll.first.next.getElement());
        assertEquals("five", ll.last.getElement());
        assertEquals("four", ll.last.prev.getElement());
        assertEquals("one", ll.first.next.prev.getElement());
    }

    @Test
    public void get() throws Exception {
        ll.add("one");
        ll.add("two");
        ll.add("three");
        ll.add("four");
        ll.add("five");
        assertEquals("one", ll.get(0));
        assertEquals("two", ll.get(1));
        assertEquals("three", ll.get(2));
        assertEquals("four", ll.get(3));
        assertEquals("five", ll.get(4));
    }

    @Test
    public void removeMiddle() throws Exception {
        ll.add("one");
        ll.add("two");
        ll.add("three");
        ll.remove(1);
        assertEquals(2, ll.size());
        assertEquals("one", ll.last.prev.getElement());
        assertEquals("three", ll.first.next.getElement());
    }

    @Test
    public void removeFirstAndLast() throws Exception {
        ll.add("one");
        ll.add("two");
        ll.add("three");
        ll.add("four");
        ll.add("five");
        ll.remove(0);
        ll.remove(4);
        assertEquals(3, ll.size());
        assertEquals("two", ll.first.getElement());
        assertEquals("four", ll.last.getElement());
        assertEquals("three", ll.last.prev.getElement());
        assertEquals("three", ll.first.next.getElement());
    }

}