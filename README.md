# N-Way Set Associative Cache

This project implements a flexible and efficient N-Way Set Associative Cache in Java. It provides a generic cache structure with customizable replacement algorithms.

## Features

- Generic implementation supporting any key-value types
- Configurable cache size and set count
- Extensible replacement algorithm interface
- Included FIFO and LRU replacement algorithms
- Thread-safe design (Note: Concurrency aspects need to be verified)

## Structure

The project consists of the following main components:

- `NWaySetAssociativeCache`: The main cache class
- `CacheSet`: Represents a single set in the cache
- `CacheEntry`: Holds a key-value pair along with metadata
- `ReplacementAlgorithm`: Interface for implementing cache replacement policies
- `FIFOReplacementAlgorithm`: First-In-First-Out replacement policy
- `LRUReplacementAlgorithm`: Least Recently Used replacement policy

## Usage

Here's a basic example of how to use the cache:

```java
// Create a cache with 4-way set associativity, 16 sets, using LRU replacement
ReplacementAlgorithm<String, Integer> lru = new LRUReplacementAlgorithm<>();
NWaySetAssociativeCache<String, Integer> cache = new NWaySetAssociativeCache<>(4, 16, lru);

// Add items to the cache
cache.put("key1", 100);
cache.put("key2", 200);

// Retrieve items
Integer value = cache.get("key1");
```

## Extending the Cache

You can create custom replacement algorithms by implementing the `ReplacementAlgorithm` interface:

```java
public class CustomReplacementAlgorithm<K, V> implements ReplacementAlgorithm<K, V> {
    @Override
    public void accessEntry(CacheEntry<K, V> entry) {
        // Implementation
    }

    @Override
    public CacheEntry<K, V> chooseReplacement(List<CacheEntry<K,V>> entries) {
        // Implementation
    }
}
```

## Future Improvements

- Add unit tests
- Implement thread-safety measures
- Add more sophisticated replacement algorithms (e.g., LFU)
- Improve performance for large cache sizes
- Add statistics tracking (hit rate, miss rate, etc.)
