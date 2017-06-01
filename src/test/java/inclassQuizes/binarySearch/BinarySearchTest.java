package inclassQuizes.binarySearch;

import org.junit.Test;

import static org.junit.Assert.*;


public class BinarySearchTest {
    @Test
    public void testBinarySearchFound() throws Exception {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        int el = BinarySearch.binarySearch(5, arr);

        assertEquals(4, el);
    }

    @Test
    public void testBinarySearchNotFound() throws Exception{
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        int el = BinarySearch.binarySearch(9, arr);

        assertEquals(-1, el);
    }

}