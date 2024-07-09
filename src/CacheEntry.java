public class CacheEntry<K, V> {
    K key;
    V value;
    long lastAccessTime;

    public CacheEntry(K key, V value) {
        this.key = key;
        this.value = value;
        this.lastAccessTime = System.currentTimeMillis();
    }
}
