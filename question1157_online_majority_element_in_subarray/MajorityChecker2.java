package question1157_online_majority_element_in_subarray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityChecker2 {

    private static class Node {

        int val;

        int count;

        public Node(int val, int count) {
            this.val = val;
            this.count = count;
        }

    }

    private Node[] tree;

    private int[] data;

    private Map<Integer, List<Integer>> num2Indexes = new HashMap<>();

    public MajorityChecker2(int[] arr) {
        tree = new Node[arr.length << 2];
        data = arr;
        buildSegmentTree(0, 0, data.length - 1);
        for (int i = 0; i < data.length; i++) {
            List<Integer> indexes = num2Indexes.get(data[i]);
            if (null == indexes) {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(i);
                num2Indexes.put(data[i], tmp);
            } else {
                indexes.add(i);
            }
        }
    }

    private void buildSegmentTree(int treeIndex, int left, int right) {
        if (left == right) {
            tree[treeIndex] = new Node(data[left], 1);
            return;
        }
        int leftTreeIndex = leftChild(treeIndex), rightTreeIndex = rightChild(treeIndex);
        int mid = left + ((right - left) >> 1);
        buildSegmentTree(leftTreeIndex, left, mid);
        buildSegmentTree(rightTreeIndex, mid + 1, right);
        tree[treeIndex] = merge(tree[leftTreeIndex], tree[rightTreeIndex]);
    }

    private Node query(int treeIndex, int left, int right, int queryLeft, int queryRight) {
        if (queryLeft <= left && queryRight >= right) {
            return tree[treeIndex];
        }
        int mid = left + ((right - left) >> 1);
        if (queryLeft > mid) {
            return query(rightChild(treeIndex), mid + 1, right, queryLeft, queryRight);
        }
        if (queryRight <= mid) {
            return query(leftChild(treeIndex), left, mid, queryLeft, queryRight);
        }
        Node leftResult = query(leftChild(treeIndex), left, mid, queryLeft, mid);
        Node rightResult = query(rightChild(treeIndex), mid + 1, right, mid + 1, queryRight);
        return merge(leftResult, rightResult);
    }

    private Node merge(Node node1, Node node2) {
        if (node1.val == node2.val) {
            return new Node(node1.val, node1.count + node2.count);
        }
        if (node1.count > node2.count) {
            return new Node(node1.val, node1.count - node2.count);
        }
        return new Node(node2.val, node2.count - node1.count);
    }

    private static int leftChild(int treeIndex) {
        return 2 * treeIndex + 1;
    }

    private static int rightChild(int treeIndex) {
        return 2 * treeIndex + 2;
    }
    
    public int query(int left, int right, int threshold) {
        Node node = query(0, 0, data.length - 1, left, right);
        List<Integer> indexes = num2Indexes.get(node.val);
        return floor(indexes, right) - ceil(indexes, left) + 1 >= threshold ? node.val : -1;
    }

    private static int ceil(List<Integer> nums, int target) {
        int left = 0, right = nums.size() - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums.get(mid) == target) {
                left = mid + 1;
            } else if (nums.get(mid) > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (right >= 0 && nums.get(right) == target) {
            return right;
        }
        return left;
    }

    private static int floor(List<Integer> nums, int target) {
        int left = 0, right = nums.size() - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums.get(mid) == target) {
                right = mid - 1;
            } else if (nums.get(mid) > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (left < nums.size() && nums.get(left) == target) {
            return left;
        }
        return right;
    }

}