package inclassQuizes.structures.stack;

import org.junit.Before;
import org.junit.Test;
import org.omg.CORBA.INTERNAL;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.List;

import static org.junit.Assert.*;


public class MyLinkedListStackTest {

    MyLinkedListStack<Integer> stack = new MyLinkedListStack<>();

    @Before
    public void init(){
        stack = new MyLinkedListStack<>();
    }

    @Test
    public void testPush() throws Exception {
        stack.push(1);
        assertEquals(1, (int)stack.pop());
    }

    @Test
    public void testOrder() throws Exception {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(5);
        stack.push(10);
        assertEquals(5, stack.size());
        assertEquals(10, (int)stack.pop());
        assertEquals(5, (int)stack.pop());
        assertEquals(3, (int)stack.pop());
        assertEquals(2, (int)stack.pop());
        assertEquals(1, (int)stack.pop());
    }

    @Test
    public void testPop() throws Exception {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        int i = stack.pop();
        assertEquals(3, i);
    }

    @Test(expected = EmptyStackException.class)
    public void testEmpty() throws Exception{
        stack.push(1);
        stack.pop();
        stack.pop();
    }

    @Test
    public void testIterator() throws Exception{
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        Integer[] need = {5, 4, 3, 2, 1};
        List<Integer> actual = new ArrayList<>();

        for(Integer i : stack){
            actual.add(i);
        }

        assertArrayEquals(need, actual.toArray());
    }


}