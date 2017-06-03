package inclassQuizes.structures.stack;

import org.junit.Test;

import static com.sun.org.apache.xml.internal.security.keys.keyresolver.KeyResolver.iterator;
import static org.junit.Assert.*;


public class LinkedListStackIteratorTest {

    MyLinkedListStack<Integer> stack = new MyLinkedListStack<>();

    @Test
    public void hasNext() throws Exception {
        stack.push(1);
        stack.push(2);
        stack.push(3);
    }

    @Test
    public void next() throws Exception {
    }

}