package question303;

public class NumArray2 {
    private class SegmentTree {
        private Integer[] tree;
        private Integer[] data;

        public SegmentTree(Integer[] arr) {
            data = new Integer[arr.length];
            for (int i = 0; i < arr.length; i++) {
                data[i] = arr[i];
            }
            tree = new Integer[4 * arr.length];
            buildSegmentTree(0, 0, data.length - 1);
        }

        /*
         * 在treeIndex的位置创建表示区间[left, right]的线段树
         */
        private void buildSegmentTree(int treeIndex, int left, int right) {
            if (left == right) {
                tree[treeIndex] = data[left];
                return;
            }
            int leftTreeIndex = leftChild(treeIndex);
            int rightTreeIndex = rightChild(treeIndex);
            int mid = left + (right - left) / 2;            //为了防止数据越界！！！
            buildSegmentTree(leftTreeIndex, left, mid);
            buildSegmentTree(rightTreeIndex, mid + 1, right);
            tree[treeIndex] = tree[leftTreeIndex] + tree[rightTreeIndex];
        }

        /*
         * 返回满二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
         */
        private int leftChild(int index) {
            return 2 * index + 1;
        }

        /*
         * 返回满二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
         */
        private int rightChild(int index) {
            return 2 * index + 2;
        }

        /*
         * 在线段树中所涉及的操作不需要通过一个节点去寻找它的父亲节点，因此不需要parent()这个函数
         */
        /*
         * 返回区间[queryL, queryR]的值
         */
        public Integer query(int queryL, int queryR) {
            return query(0, 0, data.length - 1, queryL, queryR);
        }

        /*
         * 在以treeID为根的线段树中[left...right]的范围里，搜索区间[queryL...queryR]的值
         */
        private Integer query(int treeIndex, int left, int right, int queryL, int queryR) {
            if (left == queryL && right == queryR) {
                return tree[treeIndex];
            }
            int mid = left + (right - left) / 2;
            int leftTreeIndex = leftChild(treeIndex);
            int rightTreeIndex = rightChild(treeIndex);
            if (queryL >= mid + 1) {
                return query(rightTreeIndex, mid + 1, right, queryL, queryR);
            } else if (queryR <= mid) {
                return query(leftTreeIndex, left, mid, queryL, queryR);
            } else {
                Integer leftResult = query(leftTreeIndex, left, mid, queryL, mid);
                Integer rightResult = query(rightTreeIndex, mid + 1, right, mid + 1, queryR);
                return leftResult + rightResult;
            }
        }
    }

    private SegmentTree segmentTree;

    public NumArray2(int[] nums) {
        if (nums.length > 0) {
            Integer[] data = new Integer[nums.length];    //int[]是不能自动包装转换为Integer[]的！！！
            for (int i = 0; i < nums.length; i++) {
                data[i] = nums[i];
            }
            segmentTree = new SegmentTree(data);
        }
    }

    public int sumRange(int i, int j) {
        return segmentTree.query(i, j);
    }
}