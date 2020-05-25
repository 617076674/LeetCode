package question0146_lru_cache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 自定义一个类 LRULinedHashMap 继承自 LinkedHashMap，并重写其 removeEldestEntry 方法。
 *
 * get() 和 put() 的时间复杂度均是 O(1)。空间复杂度是 O(n)，其中 n 为缓存的键数。
 *
 * 执行用时：21ms，击败57.19%。消耗内存：47.6MB，击败100.00%。
 */
public class LRUCache2 {
    private class LRULinkedHashMap<K, V> extends LinkedHashMap<K, V> {
        @Override
        protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            if (size() > capacity) {
                return true;
            }
            return false;
        }
    }

    private int capacity;

    private LRULinkedHashMap<Integer, Integer> lruLinkedHashMap = new LRULinkedHashMap<>();

    public LRUCache2(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        Integer value = lruLinkedHashMap.get(key);
        if (null == value) {
            return -1;
        }
        lruLinkedHashMap.remove(key);
        lruLinkedHashMap.put(key, value);
        return value;
    }

    public void put(int key, int value) {
        if (lruLinkedHashMap.containsKey(key)) {
            lruLinkedHashMap.remove(key);
        }
        lruLinkedHashMap.put(key, value);
    }
}