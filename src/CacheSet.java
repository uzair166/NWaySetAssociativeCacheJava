import java.util.ArrayList;
import java.util.List;

public class CacheSet<K, V> {
    List<CacheEntry<K,V>> entries;
    int size;
    ReplacementAlgorithm<K,V> replacementAlgorithm;

    public CacheSet(int size, ReplacementAlgorithm<K, V> replacementAlgorithm) {
        this.size = size;
        this.entries = new ArrayList<>(size);
        this.replacementAlgorithm = replacementAlgorithm;
    }

    public void put(K key, V value) {
        CacheEntry<K, V> entry = new CacheEntry<>(key, value);

        // check if the set is full
        if(entries.size() >= size) {
            replacementAlgorithm.chooseReplacement(entries);
            return;
        }

        // check if the key already exists
        for (int i = 0; i < entries.size(); i++) {
            if(entries.get(i).key.equals(key)) {
                entries.set(i, entry);
                return;
            }
        }

        entries.add(entry);
    }

    public V get(K key) {
        for (CacheEntry<K, V> entry : entries) {
            if (entry.key.equals(key)) {
                replacementAlgorithm.accessEntry(entry);
                return entry.value;
            }
        }
        return null;
    }
}
