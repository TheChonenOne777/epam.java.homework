package inclassQuizes.structures.list;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class MyArrayListTest {

    MyArrayList<Integer> myList = new MyArrayList(5);

    private void addElementsToList(int max){
        for (int i = 0; i < max; i++) {
            myList.add(i);
        }
    }

    @Test
    public void addElements() throws Exception{
        addElementsToList(3);
        assertEquals(3, myList.size());
        assertArrayEquals(new Object[]{0, 1, 2, null, null}, myList.objects);
    }

    @Test
    public void removeFirst() throws Exception{
        addElementsToList(5);
        myList.remove(0);
        assertEquals(4, myList.size());
        assertArrayEquals(new Object[]{1, 2, 3, 4, null}, myList.objects);
    }

    @Test
    public void removeRandThreeElements() throws Exception{
        addElementsToList(5);
        myList.remove(4);
        myList.remove(3);
        myList.remove(1);
        assertEquals(2, myList.size());
        assertArrayEquals(new Object[]{0, 2, null, null, null}, myList.objects);
    }

    @Test
    public void capacityTest() throws Exception{
        addElementsToList(8);
        assertEquals(8, myList.objects.length);
    }

}