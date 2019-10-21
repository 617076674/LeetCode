package question0303_range_sum_query_immutable;

/**
 * 线段树。
 *
 * 构造函数的时间复杂度是O(n)，其中n是nums数组的长度。sumRange()函数的时间复杂度是O(log(n))。
 *
 * 执行用时：81ms，击败81.74%。消耗内存：42.4MB，击败89.84%。
 */
public class NumArray2 {
    private class SegmentTree {
        private Integer[] tree;

        private Integer[] data;

        public SegmentTree(Integer[] arr) {
            data = new Integer[arr.length];
            for (int i = 0; i < arr.length; i++) {
                data[i] = arr[i];
            }
            tree = new Integer[arr.length << 2];
            buildSegmentTree(0, 0, data.length - 1);
        }

        private void buildSegmentTree(int treeIndex, int left, int right) {
            if (left == right) {
                tree[treeIndex] = data[left];
                return;
            }
            int leftTreeIndex = 2 * treeIndex + 1, rightTreeIndex = 2 * treeIndex + 2, mid = left + ((right - left) >> 1);
            buildSegmentTree(leftTreeIndex, left, mid);
            buildSegmentTree(rightTreeIndex, mid + 1, right);
            tree[treeIndex] = tree[leftTreeIndex] + tree[rightTreeIndex];
        }

        public Integer query(int queryL, int queryR) {
            return query(0, 0, data.length - 1, queryL, queryR);
        }

        private Integer query(int treeIndex, int left, int right, int queryL, int queryR) {
            if (left == queryL && right == queryR) {
                return tree[treeIndex];
            }
            int leftTreeIndex = 2 * treeIndex + 1, rightTreeIndex = 2 * treeIndex + 2, mid = left + ((right - left) >> 1);
            if (queryL >= mid + 1) {
                return query(rightTreeIndex, mid + 1, right, queryL, queryR);
            } else if (queryR <= mid) {
                return query(leftTreeIndex, left, mid, queryL, queryR);
            }
            return query(leftTreeIndex, left, mid, queryL, mid) + query(rightTreeIndex, mid + 1, right, mid + 1, queryR);
        }
    }

    private SegmentTree segmentTree;

    public NumArray2(int[] nums) {
        int n = nums.length;
        if (n > 0) {
            Integer[] data = new Integer[n];
            for (int i = 0; i < n; i++) {
                data[i] = nums[i];
            }
            segmentTree = new SegmentTree(data);
        }
    }

    public int sumRange(int i, int j) {
        return segmentTree.query(i, j);
    }
}