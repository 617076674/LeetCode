package question0381_insert_delete_getrandom_o1_duplicates_allowed;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RandomizedCollection {

    private Map<Integer, Set<Integer>> num2IndexSet = new HashMap<>();

    // 为了使得 O(1) 时间内能够随机获取一个元素，我们将每个数值（可以重复）存储在一个列表 list 中。
    // 这样，获取随机元素时，只要随机生成一个列表中的索引，就能够得到一个随机元素。
    private List<Integer> list = new ArrayList<>();

    /** Initialize your data structure here. */
    public RandomizedCollection() {

    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        list.add(val);
        Set<Integer> integerSet = num2IndexSet.get(val);
        if (null == integerSet) {
            Set<Integer> tmp = new HashSet<>();
            tmp.add(list.size() - 1);
            num2IndexSet.put(val, tmp);
            return true;
        }
        integerSet.add(list.size() - 1);
        return integerSet.isEmpty();
    }

    // 在删除元素时，我们可以将被删的元素与列表中最后一个元素交换位置，随后便可以在 O(1) 的时间内，从列表中去除该元素。
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        Set<Integer> indexSet = num2IndexSet.get(val);
        if (null == indexSet || indexSet.isEmpty()) {
            // 如果不存在该值，不用删除，直接返回 false
            return false;
        }
        // 需要删除 list 中索引为 index 的元素
        int index = indexSet.iterator().next();
        // list 中最后一个元素的值是 lastVal
        int lastVal = list.get(list.size() - 1);
        if (index == list.size() - 1) {
            // 要删除的元素就是 list 中的最后一个元素
            indexSet.remove(index);
            list.remove(list.size() - 1);
            return true;
        }
        indexSet.remove(index);
        num2IndexSet.get(lastVal).add(index);
        num2IndexSet.get(lastVal).remove(list.size() - 1);
        list.set(index, lastVal);
        list.remove(list.size() - 1);
        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get((int) (Math.random() * list.size()));
    }

}