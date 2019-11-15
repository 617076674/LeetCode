package question0170_two_sum_iii_data_structure_design;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/two-sum-iii-data-structure-design/
 *
 * 哈希表。
 *
 * 执行用时：218ms，击败51.08%。消耗内存：53MB，击败100.00%。
 */
public class TwoSum {
    private Map<Integer, Integer> map;

    /** Initialize your data structure here. */
    public TwoSum() {
        map = new HashMap<>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        if (map.containsKey(number)) {
            map.put(number, map.get(number) + 1);
        } else {
            map.put(number, 1);
        }
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for (int num : map.keySet()) {
            if (num == value - num) {
                if (map.get(num) >= 2) {
                    return true;
                }
            } else if (map.containsKey(value - num)) {
                return true;
            }
        }
        return false;
    }
}