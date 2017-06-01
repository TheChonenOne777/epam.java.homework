package inclassQuizes.structures.queue;

import org.junit.Test;

import java.util.EmptyStackException;

import static org.junit.Assert.*;


public class MyLinkedListQueueTest {

    MyLinkedListQueue<Integer> queue = new MyLinkedListQueue<>();

    @Test
    public void testEnqueue() throws Exception{
        queue.enqueue(5);
        assertEquals(1, queue.size());
        assertEquals(5, (int)queue.dequeue());
    }

    @Test
    public void testDequeueOrder() throws Exception{
        queue.enqueue(1);
        queue.enqueue(3);
        queue.enqueue(5);
        queue.enqueue(7);
        queue.enqueue(8);
        assertEquals(5, queue.size());
        assertEquals(1, (int)queue.dequeue());
        assertEquals(3, (int)queue.dequeue());
        assertEquals(5, (int)queue.dequeue());
        assertEquals(7, (int)queue.dequeue());
        assertEquals(8, (int)queue.dequeue());
    }

    @Test(expected = EmptyStackException.class)
    public void testEmptyOrder(){
        queue.enqueue(1);
        queue.dequeue();
        queue.dequeue();
    }

}