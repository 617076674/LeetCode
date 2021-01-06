package question0303_range_sum_query_immutable;

/**
 * 线段树。
 *
 * 构造函数的时间复杂度是O(n)，其中n是nums数组的长度。sumRange()函数的时间复杂度是O(log(n))。
 *
 * 执行用时：81ms，击败81.74%。消耗内存：42.4MB，击败89.84%。
 */
public class NumArray2 {

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
            } else if (queryR <= mid) {
                return query(leftTreeIndex, left, mid, queryL, queryR);
            }
            return query(leftTreeIndex, left, mid, queryL, mid) +
                query(rightTreeIndex, mid + 1, right, mid + 1, queryR);
        }

        private static int leftChild(int treeIndex) {
            return 2 * treeIndex + 1;
        }

        private static int rightChild(int treeIndex) {
            return 2 * treeIndex + 2;
        }

    }

    private SegmentTree segmentTree;

    public NumArray2(int[] nums) {
        if (nums.length > 0) {
            segmentTree = new SegmentTree(nums);
        }
    }

    public int sumRange(int i, int j) {
        return null == segmentTree ? 0 : segmentTree.query(i, j);
    }

}