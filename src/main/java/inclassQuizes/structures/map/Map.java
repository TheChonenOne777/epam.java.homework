package inclassQuizes.structures.map;


public interface Map<K, V> {
    void put(K key, V value);
    V get(K key);
    V getOrDefault(K key, V defaultValue);
    int size();
    boolean remove(K key);
}
