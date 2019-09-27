package question0705_design_hashset;

/**
 * add()、remove()和contains()函数的时间复杂度均是O(1)。
 *
 * 执行用时：69ms，击败99.43%。消耗内存：57.4MB，击败90.43%。
 */
public class MyHashSet {
    private boolean[] table;

    /** Initialize your data structure here. */
    public MyHashSet() {
        table = new boolean[1000001];
    }
    
    public void add(int key) {
        table[key] = true;
    }
    
    public void remove(int key) {
        table[key] = false;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return table[key];
    }
}