package inclassQuizes.structures.map;


public class MyHashMap<K, V> implements Map<K, V> {

    Entry<K, V>[] buckets;
    int size;
    V nullValue;
    float loadFactor = 0.75f;

    public MyHashMap() {
        buckets = new Entry[16];
    }

    public MyHashMap(int capacity) {
        buckets = new Entry[capacity];
    }

    public MyHashMap(int capacity, float loadFactor) {
        buckets = new Entry[capacity];
        this.loadFactor = loadFactor;
    }

    @Override
    public void put(K key, V value) {
        Entry<K, V> newEntry = new Entry<>(key, value);
        if (key == null) {
            nullValue = value;
        }
        int hash = key.hashCode();
        int index = indexNum(hash, buckets.length);

        Entry<K, V> cur = buckets[index];

        if (cur == null) {
            buckets[index] = newEntry;
            size++;
        } else {
            Entry<K, V> prev = null;
            while (cur != null) {
                if (cur.getKey().equals(key)) {
                    cur.value = value;
                    break;
                }
                prev = cur;
                cur = cur.next;
            }
            if(cur == null){
                prev.next = newEntry;
                size++;
            }
        }
        if(size > loadFactor * buckets.length){
            grow();
        }
    }

    private void grow() {
        int capacity = buckets.length << 1;
        Entry<K, V>[] oldData = buckets;
        buckets = new Entry[capacity];
        size = 0;
        for(Entry<K, V> bucket : oldData){
            Entry<K, V> entry = bucket;
            while(entry != null){
                put(entry.key, entry.value);
                entry = entry.next;
            }
        }
    }

    @Override
    public V get(K key) {
        return getOrDefault(key, null);
    }

    @Override
    public V getOrDefault(K key, V defaultValue) {
        if (key == null) {
            return nullValue;
        }
        int hash = key.hashCode();
        int index = indexNum(hash, buckets.length);
        Entry<K, V> newEntry = buckets[index];
        while (newEntry != null) {
            if (newEntry.getKey().equals(key)) {
                return newEntry.getValue();
            }
            newEntry = newEntry.next;
        }
        return defaultValue;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean remove(K key) {
        if (key == null) {
            nullValue = null;
            return true;
        }
        int hash = key.hashCode();
        int index = indexNum(hash, buckets.length);
        if (buckets[index] == null) {
            return false;
        }
        Entry<K, V> cur = buckets[index];
        Entry<K, V> prev = null;
        while (cur != null) {
            if (cur.getKey().equals(key)) {
                if (prev == null) {
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
        }
        return false;
    }

    private int indexNum(int hash, int length) {
        if (length % 2 == 0) {
            return hash & (length - 1);
        } else {
            return hash % length;
        }
    }

    static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next = null;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public V getValue() {
            return value;
        }

        public K getKey() {
            return key;
        }
    }

}
