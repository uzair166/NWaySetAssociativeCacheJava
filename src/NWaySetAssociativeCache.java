import java.util.ArrayList;
import java.util.List;

public class NWaySetAssociativeCache<K, V> {
    int setSize;
    int setCount;
    List<CacheSet<K, V>> sets;
    ReplacementAlgorithm<K,V> replacementAlgorithm;

    public NWaySetAssociativeCache(int setSize, int setCount, ReplacementAlgorithm<K,V> replacementAlgorithm) {
        this.setSize = setSize;
        this.setCount = setCount;
        sets = new ArrayList<>(setCount);
        for (int i=0; i<setCount; i++){
            sets.add(new CacheSet<K, V>(setSize, replacementAlgorithm));
        }
    }

    public void put(K key, V value) {
        int setIndex = getSetIndex(key);
        sets.get(setIndex).put(key, value);
    }

    private int getSetIndex(K key) {
        return Math.abs(key.hashCode() % setCount);
    }

    public V get(K key, V value) {
        int setIndex = getSetIndex(key);
        return sets.get(setIndex).get(key);
    }


}
