package question2213;

/**
 * 线段树经典例题。
 */
public class Solution {

    private static class SegmentTreeNode {
      int left; // 区间左端点
      int right;  // 区间右端点
      int lmax; // 紧靠左端的单个字符重复组成的最长子字符串的长度
      int rmax; // 紧靠右端的单个字符重复组成的最长子字符串的长度
      int dat;  // 区间内单个字符重复组成的最长子字符串的长度
      char leftChar;  // 区间左端点对应的字符
      char rightChar; // 区间右端点对应的字符
      int len;  // 区间长度
    }

    private SegmentTreeNode[] nodes;

    private String s;

    private void buildSegmentTree(int treeIndex, int left, int right) {
      nodes[treeIndex] = new SegmentTreeNode();
      nodes[treeIndex].left = left;
      nodes[treeIndex].right = right;
      nodes[treeIndex].leftChar = s.charAt(left);
      nodes[treeIndex].rightChar = s.charAt(right);
      if (left == right) {
        nodes[treeIndex].lmax = 1;
        nodes[treeIndex].rmax = 1;
        nodes[treeIndex].dat = 1;
        nodes[treeIndex].len = 1;
        return;
      }
      int mid = (nodes[treeIndex].left + nodes[treeIndex].right) / 2;
      buildSegmentTree(leftChild(treeIndex), left, mid);
      buildSegmentTree(rightChild(treeIndex), mid + 1, right);
      nodes[treeIndex].lmax = nodes[leftChild(treeIndex)].lmax;
      if (nodes[leftChild(treeIndex)].lmax == nodes[leftChild(treeIndex)].len && nodes[leftChild(treeIndex)].rightChar == nodes[rightChild(treeIndex)].leftChar) {
        nodes[treeIndex].lmax += nodes[rightChild(treeIndex)].lmax;
      }
      nodes[treeIndex].rmax = nodes[rightChild(treeIndex)].rmax;
      if (nodes[rightChild(treeIndex)].rmax == nodes[rightChild(treeIndex)].len && nodes[leftChild(treeIndex)].rightChar == nodes[rightChild(treeIndex)].leftChar) {
        nodes[treeIndex].rmax += nodes[leftChild(treeIndex)].rmax;
      }
      nodes[treeIndex].dat = Math.max(nodes[leftChild(treeIndex)].dat, nodes[rightChild(treeIndex)].dat);
      if (nodes[leftChild(treeIndex)].rightChar == nodes[rightChild(treeIndex)].leftChar) {
        nodes[treeIndex].dat = Math.max(nodes[treeIndex].dat, nodes[leftChild(treeIndex)].rmax + nodes[rightChild(treeIndex)].lmax);
      }
      nodes[treeIndex].len = nodes[leftChild(treeIndex)].len + nodes[rightChild(treeIndex)].len;
    }

    private void update(int treeIndex, int x, char c) {
      if (nodes[treeIndex].left == nodes[treeIndex].right) {
        nodes[treeIndex].leftChar = c;
        nodes[treeIndex].rightChar = c;
        return;
      }
      int mid = (nodes[treeIndex].left + nodes[treeIndex].right) / 2;
      if (x <= mid) {
        update(leftChild(treeIndex), x, c);
      } else {
        update(rightChild(treeIndex), x, c);
      }
      nodes[treeIndex].lmax = nodes[leftChild(treeIndex)].lmax;
      if (nodes[leftChild(treeIndex)].lmax == nodes[leftChild(treeIndex)].len && nodes[leftChild(treeIndex)].rightChar == nodes[rightChild(treeIndex)].leftChar) {
        nodes[treeIndex].lmax += nodes[rightChild(treeIndex)].lmax;
      }
      nodes[treeIndex].rmax = nodes[rightChild(treeIndex)].rmax;
      if (nodes[rightChild(treeIndex)].rmax == nodes[rightChild(treeIndex)].len && nodes[leftChild(treeIndex)].rightChar == nodes[rightChild(treeIndex)].leftChar) {
        nodes[treeIndex].rmax += nodes[leftChild(treeIndex)].rmax;
      }
      nodes[treeIndex].dat = Math.max(nodes[leftChild(treeIndex)].dat, nodes[rightChild(treeIndex)].dat);
      if (nodes[leftChild(treeIndex)].rightChar == nodes[rightChild(treeIndex)].leftChar) {
        nodes[treeIndex].dat = Math.max(nodes[treeIndex].dat, nodes[leftChild(treeIndex)].rmax + nodes[rightChild(treeIndex)].lmax);
      }
      nodes[treeIndex].leftChar = nodes[leftChild(treeIndex)].leftChar;
      nodes[treeIndex].rightChar = nodes[rightChild(treeIndex)].rightChar;
      nodes[treeIndex].len = nodes[leftChild(treeIndex)].len + nodes[rightChild(treeIndex)].len;
    }

    private SegmentTreeNode query(int treeIndex, int left, int right) {
      if (left <= nodes[treeIndex].left && nodes[treeIndex].right <= right) {
        return nodes[treeIndex];
      }
      int mid = (nodes[treeIndex].left + nodes[treeIndex].right) / 2;
      if (left <= mid && mid < right) {
        SegmentTreeNode leftResult = query(leftChild(treeIndex), left, right);
        SegmentTreeNode rightResult = query(rightChild(treeIndex), left, right);
        SegmentTreeNode res = new SegmentTreeNode();
        res.left = leftResult.left;
        res.right = rightResult.right;
        res.leftChar = leftResult.leftChar;
        res.rightChar = rightResult.rightChar;
        res.lmax = leftResult.lmax;
        if (leftResult.lmax == leftResult.len && leftResult.rightChar == rightResult.leftChar) {
          res.lmax += rightResult.lmax;
        }
        res.rmax = rightResult.rmax;
        if (rightResult.rmax == rightResult.len && leftResult.rightChar == rightResult.leftChar) {
          res.rmax += leftResult.rmax;
        }
        res.dat = Math.max(leftResult.dat, rightResult.dat);
        if (leftResult.rightChar == rightResult.leftChar) {
          res.dat = Math.max(res.dat, leftResult.rmax + rightResult.lmax);
        }
        return res;
      }
      if (left <= mid) {
        return query(leftChild(treeIndex), left, right);
      }
      return query(rightChild(treeIndex), left, right);
    }

    private static int leftChild(int i) {
      return 2 * i + 1;
    }

    private static int rightChild(int i) {
      return 2 * i + 2;
    }

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
      nodes = new SegmentTreeNode[s.length() * 4];
      this.s = s;
      buildSegmentTree(0, 0, s.length() - 1);
      int[] result = new int[queryIndices.length];
      for (int i = 0; i < queryIndices.length; i++) {
        update(0, queryIndices[i], queryCharacters.charAt(i));
        result[i] = query(0, 0, s.length() - 1).dat;
      }
      return result;
    }

}