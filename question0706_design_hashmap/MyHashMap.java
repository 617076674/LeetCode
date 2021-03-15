package question0706_design_hashmap;

/**
 * put()、get()和remove()的时间复杂度均是O(1)。
 *
 * 执行用时：85ms，击败99.14%。消耗内存：64.4MB，击败58.10%。
 */
public class MyHashMap {

    private Integer[] table;

    /** Initialize your data structure here. */
    public MyHashMap() {
        table = new Integer[1000001];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        table[key] = value;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        return table[key] == null ? -1 : table[key];
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        table[key] = null;
    }

}