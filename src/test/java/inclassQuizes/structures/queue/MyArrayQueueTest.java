package inclassQuizes.structures.queue;

import org.junit.Test;

import java.util.EmptyStackException;

import static org.junit.Assert.*;


public class MyArrayQueueTest {
    MyArrayQueue<Integer> queue = new MyArrayQueue<>(5);

    @Test
    public void testEnqueue() throws Exception{
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        assertEquals(3, queue.size());
        assertArrayEquals(new Object[]{1, 2, 3, null, null}, queue.objects);
    }

    @Test
    public void testDequeue() throws Exception{
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        assertEquals(1, (int)queue.dequeue());
        assertEquals(2, (int)queue.dequeue());
        assertEquals(3, (int)queue.dequeue());
    }

    @Test(expected = EmptyStackException.class)
    public void testEmptyStack(){
        queue.dequeue();
    }

    @Test
    public void testEnlargeCapacity() throws Exception{
        queue.enqueue(1);
        queue.enqueue(1);
        queue.enqueue(1);
        queue.enqueue(1);
        queue.enqueue(1);
        queue.enqueue(1);
        assertEquals(7, queue.objects.length);
    }

    @Test
    public void testCycling() throws Exception{
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        assertArrayEquals(new Object[]{1, 2, 3, 4, null}, queue.objects);
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        assertArrayEquals(new Object[]{null, null, null, 4, null}, queue.objects);
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(7);
        assertArrayEquals(new Object[]{6, 7, null, 4, 5}, queue.objects);
        assertEquals(5, queue.objects.length);
    }
}