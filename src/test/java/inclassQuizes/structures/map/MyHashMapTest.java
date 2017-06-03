package inclassQuizes.structures.map;

import org.junit.Test;

import static org.junit.Assert.*;


public class MyHashMapTest {

    MyHashMap<Integer, String> hm = new MyHashMap();

    @Test
    public void testPut() throws Exception{
        hm.put(1, "hello");
        hm.put(2, "world");
        assertEquals(2, hm.size());
        assertEquals(new MyHashMap.Entry<>(1, "hello").getValue(), hm.get(1));
        assertEquals(new MyHashMap.Entry<>(2, "world").getValue(), hm.get(2));
    }

    @Test
    public void testRemove() throws Exception{
        hm.put(1, "hello");
        hm.put(2, "world");
        hm.remove(2);
        assertEquals(1, hm.size());
        assertEquals(null, hm.get(2));
    }

    @Test
    public void testCollisions() throws Exception{
        MyHashMap<Integer, String> hashMap = new MyHashMap(1);
        hashMap.put(1, "hello");
        hashMap.put(2, "world");
        assertEquals("world", hashMap.get(2));
    }



}