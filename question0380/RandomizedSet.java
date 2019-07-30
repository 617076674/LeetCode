package question0380;

import java.util.HashMap;
import java.util.Map;

/**
 * 用两个HashMap存储，其中一个存储索引到值的映射，另一个存储值到索引的映射。
 *
 * 注意，在删除val时，如果该val对应的不是最后一个索引，需要交换。
 *
 * 执行用时：125ms，击败61.98%。消耗内存：54.4MB，击败51.84%。
 */
public class RandomizedSet {

    private Map<Integer, Integer> indexToVal;

    private Map<Integer, Integer> valToIndex;

    private int count;

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        indexToVal = new HashMap<>();
        valToIndex = new HashMap<>();
        count = 0;
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (valToIndex.containsKey(val)) {
            return false;
        }
        indexToVal.put(count, val);
        valToIndex.put(val, count);
        count++;
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!valToIndex.containsKey(val)) {
            return false;
        }
        //这里要考虑的是是否这个元素本来就是最后一个如果是最后一个不需要进行交换
        //获取值的位置
        int index = valToIndex.get(val);
        count--;
        if (index == count) {
            valToIndex.remove(val);
            indexToVal.remove(count);
        } else {
            //记录地址的map删除
            valToIndex.remove(val);
            //记录值的map删除
            indexToVal.remove(index);
            //开始调换位置
            int lastValue = indexToVal.get(count);
            indexToVal.put(index, lastValue);
            //调换之后把重复值删除
            indexToVal.remove(count);
            valToIndex.put(lastValue, index);
        }
        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        return indexToVal.get((int) (Math.random() * count));
    }
}