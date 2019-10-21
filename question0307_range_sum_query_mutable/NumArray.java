package question0307_range_sum_query_mutable;

/**
 * 线段树。
 *
 * sumRange()的时间复杂度是O(logn)，其中n为nums数组中的元素个数。
 * update()的时间复杂度也是O(logn)。
 *
 * 执行用时：92ms，击败97.18%。消耗内存：46.1MB，击败99.18%。
 */
public class NumArray {
    private class SegmentTree {
        private int[] tree;

        private int[] data;

        public SegmentTree(int[] arr) {
            data = new int[arr.length];
            for (int i = 0; i < arr.length; i++) {
                data[i] = arr[i];
            }
            tree = new int[arr.length << 2];
            buildSegmentTree(0, 0, data.length - 1);
        }

        private void buildSegmentTree(int treeIndex, int left, int right) {
            if (left == right) {
                tree[treeIndex] = data[left];
                return;
            }
            int leftTreeIndex = 2 * treeIndex + 1, rightTreeIndex = 2 * treeIndex + 2, mid = left + ((right - left) >> 1);            //为了防止数据越界！！！
            buildSegmentTree(leftTreeIndex, left, mid);
            buildSegmentTree(rightTreeIndex, mid + 1, right);
            tree[treeIndex] = tree[leftTreeIndex] + tree[rightTreeIndex];
        }

        public int query(int queryL, int queryR) {
            return query(0, 0, data.length - 1, queryL, queryR);
        }

        private int query(int treeIndex, int left, int right, int queryL, int queryR) {
            if (left == queryL && right == queryR) {
                return tree[treeIndex];
            }
            int mid = left + ((right - left) >> 1), leftTreeIndex = 2 * treeIndex + 1, rightTreeIndex = 2 * treeIndex + 2;
            if (queryL >= mid + 1) {
                return query(rightTreeIndex, mid + 1, right, queryL, queryR);
            }
            if (queryR <= mid) {
                return query(leftTreeIndex, left, mid, queryL, queryR);
            }
            return query(leftTreeIndex, left, mid, queryL, mid) + query(rightTreeIndex, mid + 1, right, mid + 1, queryR);
        }

        public void update(int i, int val) {
            data[i] = val;
            update(0, 0, data.length - 1, i, val);
        }

        private void update(int treeIndex, int left, int right, int index, int e) {
            if (left == right) {
                tree[treeIndex] = e;
                return;
            }
            int mid = left + ((right - left) >> 1), leftTreeIndex = 2 * treeIndex + 1, rightTreeIndex = 2 * treeIndex + 2;
            if (index >= mid + 1) {
                update(rightTreeIndex, mid + 1, right, index, e);
            } else {
                update(leftTreeIndex, left, mid, index, e);
            }
            tree[treeIndex] = tree[leftTreeIndex] + tree[rightTreeIndex];
        }
    }

    private SegmentTree segmentTree;

    public NumArray(int[] nums) {
        int n = nums.length;
        if (n > 0) {
            int[] data = new int[n];    //int[]是不能自动包装转换为Integer[]的！！！
            for (int i = 0; i < n; i++) {
                data[i] = nums[i];
            }
            segmentTree = new SegmentTree(data);
        }
    }

    public void update(int i, int val) {
        segmentTree.update(i, val);
    }

    public int sumRange(int i, int j) {
        return segmentTree.query(i, j);
    }
}