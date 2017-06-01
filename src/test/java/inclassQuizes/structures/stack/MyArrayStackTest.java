package inclassQuizes.structures.stack;

import org.junit.Test;

import java.util.EmptyStackException;

import static org.junit.Assert.*;


public class MyArrayStackTest {

    MyArrayStack<Integer> stack = new MyArrayStack<>(5);

    @Test
    public void testPush() throws Exception {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertArrayEquals(new Object[]{1, 2, 3, null, null}, stack.objects);
    }

    @Test
    public void testPushGrow() throws Exception{
        stack.push(1);
        stack.push(1);
        stack.push(1);
        stack.push(1);
        stack.push(1);
        stack.push(1);
        assertArrayEquals(new Object[]{1, 1, 1, 1, 1, 1, null}, stack.objects);
    }

    @Test
    public void testOrder() throws Exception {
        stack.push(1);
        stack.push(4);
        stack.push(7);
        stack.push(3);
        assertEquals(3, (int)stack.pop());
        assertEquals(7, (int)stack.pop());
        assertEquals(4, (int)stack.pop());
        assertEquals(1, (int)stack.pop());
    }

    @Test(expected = EmptyStackException.class)
    public void testEmptyStack(){
        stack.push(1);
        stack.pop();
        stack.pop();
    }

}