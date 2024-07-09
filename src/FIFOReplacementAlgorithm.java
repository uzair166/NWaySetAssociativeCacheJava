import java.util.List;

public class FIFOReplacementAlgorithm<K,V> implements ReplacementAlgorithm<K,V>{
    @Override
    public void accessEntry(CacheEntry<K, V> entry) {
        return;
    }

    @Override
    public CacheEntry<K, V> chooseReplacement(List<CacheEntry<K, V>> cacheEntries) {
        return cacheEntries.get(0);
    }
}
