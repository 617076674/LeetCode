package question0146_lru_cache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 自定义一个雷LRULinedHashMap继承自LinkedHashMap，并重写其removeEldestEntry方法。
 *
 * get()和put()的时间复杂度均是O(1)。空间复杂度是O(n)，其中n为缓存的键数。
 *
 * 执行用时：78ms，击败92.94%。消耗内存：49.5MB，击败99.78%。
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