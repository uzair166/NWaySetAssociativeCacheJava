import java.util.List;

public class LRUReplacementAlgorithm<K, V> implements ReplacementAlgorithm<K, V> {
    @Override
    public void accessEntry(CacheEntry<K, V> entry) {
        entry.lastAccessTime = System.currentTimeMillis();
    }

    @Override
    public CacheEntry<K, V> chooseReplacement(List<CacheEntry<K, V>> entries){
        int oldestIndex = 0;
        long oldestAccess = Long.MAX_VALUE;

        for (int i =0; i<entries.size(); i++) {
            if(entries.get(i).lastAccessTime < oldestAccess) {
                oldestAccess = entries.get(i).lastAccessTime;
                oldestIndex = i;
            }
        }
        return entries.get(oldestIndex);
    }
}
