package inclassQuizes.structures.map;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;


public class MyHashMapTest {

    MyHashMap<Integer, String> hm = new MyHashMap();

    @Test
    public void testPut() throws Exception{
        hm.put(0, "first");
        hm.put(1, "hello");
        hm.put(2, "world");
        assertEquals(3, hm.size());
        assertEquals("first", hm.buckets[0].getValue());
        assertEquals("hello", hm.buckets[1].getValue());
        assertEquals("world", hm.buckets[2].getValue());
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
    public void testCollisionsSubstitution() throws Exception{
        hm.put(1, "hello");
        hm.put(1, "world");
        hm.put(1, "lala");
        assertEquals("lala", hm.buckets[1].getValue());
    }

    @Ignore
    @Test
    public void testCollisionsToList() throws Exception{
        MyHashMap<Integer, String> hashMap = new MyHashMap(1);
        hashMap.put(1, "hello");
        hashMap.put(2, "world");
        hashMap.put(3, "lala");
        assertEquals("hello", hashMap.buckets[0].getValue());
        assertEquals("world", hashMap.buckets[0].next.getValue());
        assertEquals("lala", hashMap.buckets[0].next.next.getValue());
    }

    @Test
    public void testGrow() throws Exception{
        MyHashMap<Integer, String> hashMap = new MyHashMap(4);
        assertEquals(4, hashMap.buckets.length);
        hashMap.put(1, "hello");
        hashMap.put(2, "world");
        hashMap.put(3, "lala");
        hashMap.put(4, "moment");
        assertEquals(8, hashMap.buckets.length);
    }

}