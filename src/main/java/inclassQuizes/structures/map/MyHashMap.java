package inclassQuizes.structures.map;


public class MyHashMap<K, V> implements Map<K, V> {

    Entry<K, V>[] buckets;
    int size;

    public MyHashMap(){
         buckets = new Entry[16];
    }

    public MyHashMap(int capacity){
        buckets = new Entry[capacity];
    }

    @Override
    public void put(K key, V value) {
        Entry<K, V> newEntry = new Entry<>(key, value);
        if(key == null){
            //call for null bucket
        }
        int hash = key.hashCode();
        int index = indexNum(hash, buckets.length);

        if(buckets[index] == null){
            buckets[index] = newEntry;
        } else {
            Entry<K, V> cur = buckets[index];
            while(true){
                if(cur.getKey() == key){
                    cur.value = value;
                    break;
                } else if(cur.getKey() == null){
                    cur.next = newEntry;
                    break;
                }
                cur = cur.next;
            }
        }
        size++;
    }

    @Override
    public V get(K key) {
        return getOrDefault(key, null);
    }

    @Override
    public V getOrDefault(K key, V defaultValue) {
        if(key == null){
            return defaultValue;
            //call for null bucket
        }
        int hash = key.hashCode();
        int index = indexNum(hash, buckets.length);
        Entry<K, V> newEntry = buckets[index];
        while(true){
            if(newEntry == null){
                return null;
            }
            if(newEntry.getKey() == key){
                return newEntry.getValue();
            }
            newEntry = newEntry.next;
            if(newEntry == null){
                return defaultValue;
            }
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean remove(K key) {
        if(key == null){
            return false;
            //null bucket
        }
        int hash = key.hashCode();
        int index = indexNum(hash, buckets.length);
        if(buckets[index] == null){
            return false;
        }
        Entry<K, V> cur = buckets[index];
        Entry<K, V> prev = null;
        while(true){
            if(cur.getKey() == key){
                if(prev == null){
                    buckets[index] = null;
                    size--;
                    return true;
                }
                prev.next = cur.next;
                size--;
                return true;
            }
            prev = cur;
            cur = cur.next;
            if(cur == null){
                return false;
            }
        }
    }

    private int indexNum(int hash, int length) {
        if(length % 2 == 0){
            return hash & (length - 1);
        } else {
            return hash % length;
        }
    }

    static class Entry<K, V>{
        K key;
        V value;
        Entry<K, V> next = null;

        public Entry(K key, V value){
            this.key = key;
            this.value = value;
        }

        public V getValue(){
            return value;
        }

        public K getKey(){
            return key;
        }
    }
}
