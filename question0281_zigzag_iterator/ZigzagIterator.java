package question0281_zigzag_iterator;

import java.util.List;

/**
 * 执行用时：2ms，击败100.00%。消耗内存：39.7MB，击败100.00%。
 */
public class ZigzagIterator {
    private int index1, index2, now;

    private List<Integer> v1, v2;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        this.v1 = v1;
        this.v2 = v2;
        now = 1;
    }

    public int next() {
        if (index1 == v1.size()) {
            now = 2;
            return v2.get(index2++);
        }
        if (index2 == v2.size()) {
            now = 1;
            return v1.get(index1++);
        }
        if (now == 1) {
            now = 2;
            return v1.get(index1++);
        }
        now = 1;
        return v2.get(index2++);
    }

    public boolean hasNext() {
        return index1 < v1.size() || index2 < v2.size();
    }
}