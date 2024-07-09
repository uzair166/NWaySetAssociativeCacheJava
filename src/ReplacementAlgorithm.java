import java.util.List;

public interface ReplacementAlgorithm<K, V> {
    void accessEntry(CacheEntry<K, V> entry);
    CacheEntry<K, V> chooseReplacement(List<CacheEntry<K,V>> entries);
}
