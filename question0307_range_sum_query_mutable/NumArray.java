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

    private static class SegmentTree {

        private int[] tree;

        private int[] data;

        public SegmentTree(int[] arr) {
            data = arr;
            tree = new int[arr.length << 2];
            buildSegmentTree(0, 0, data.length - 1);
        }

        private void buildSegmentTree(int treeIndex, int left, int right) {
            if (left == right) {
                tree[treeIndex] = data[left];
                return;
            }
            int leftTreeIndex = leftChild(treeIndex), rightTreeIndex = rightChild(treeIndex);
            int mid = left + ((right - left) >> 1);
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
            int leftTreeIndex = leftChild(treeIndex), rightTreeIndex = rightChild(treeIndex);
            int mid = left + ((right - left) >> 1);
            if (queryL >= mid + 1) {
                return query(rightTreeIndex, mid + 1, right, queryL, queryR);
            }
            if (queryR <= mid) {
                return query(leftTreeIndex, left, mid, queryL, queryR);
            }
            return query(leftTreeIndex, left, mid, queryL, mid) +
                query(rightTreeIndex, mid + 1, right, mid + 1, queryR);
        }

        public void update(int index, int val) {
            data[index] = val;
            update(0, 0, data.length - 1, index, val);
        }

        private void update(int treeIndex, int left, int right, int index, int val) {
            if (left == right) {
                tree[treeIndex] = val;
                return;
            }
            int leftTreeIndex = leftChild(treeIndex), rightTreeIndex = rightChild(treeIndex);
            int mid = left + ((right - left) >> 1);
            if (index >= mid + 1) {
                update(rightTreeIndex, mid + 1, right, index, val);
            } else {
                update(leftTreeIndex, left, mid, index, val);
            }
            tree[treeIndex] = tree[leftTreeIndex] + tree[rightTreeIndex];
        }

        private static int leftChild(int treeIndex) {
            return 2 * treeIndex + 1;
        }

        private static int rightChild(int treeIndex) {
            return 2 * treeIndex + 2;
        }

    }

    private SegmentTree segmentTree;

    public NumArray(int[] nums) {
        if (nums.length > 0) {
            segmentTree = new SegmentTree(nums);
        }
    }

    public void update(int i, int val) {
        if (null != segmentTree) {
            segmentTree.update(i, val);
        }
    }

    public int sumRange(int i, int j) {
        return null == segmentTree ? 0 : segmentTree.query(i, j);
    }

}