package question1707_maximum_xor_with_an_element_from_array;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

  private static class Trie {

    TrieNode root = new TrieNode();

    private void insert(int n) {
      String s = integer2BinaryString(n);
      TrieNode cur = root;
      for (int i = 0; i < 32; i++) {
        char c = s.charAt(i);
        if (c == '0') {
          if (cur.left == null) {
            cur.left = new TrieNode();
          }
          cur = cur.left;
        } else {
          if (cur.right == null) {
            cur.right = new TrieNode();
          }
          cur = cur.right;
        }
      }
      cur.val = n;
    }

    private int search(int n) {
      String s = integer2BinaryString(n);
      TrieNode cur = root;
      for (int i = 0; i < 32; i++) {
        char c = s.charAt(i);
        if (c == '0') {
          if (cur.right != null) {
            cur = cur.right;
          } else {
            cur = cur.left;
          }
        } else {
          if (cur.left != null) {
            cur = cur.left;
          } else {
            cur = cur.right;
          }
        }
      }
      return cur.val ^ n;
    }

    private String integer2BinaryString(int n) {
      StringBuilder sb = new StringBuilder(Integer.toBinaryString(n));
      while (sb.length() < 32) {
        sb.insert(0, '0');
      }
      return sb.toString();
    }
  }

  private static class TrieNode {
    int val;

    TrieNode left;

    TrieNode right;
  }

  private Trie trie = new Trie();

  public int[] maximizeXor(int[] nums, int[][] queries) {
    Arrays.sort(nums);
    Integer[] indexes = new Integer[queries.length];
    for (int i = 0; i < queries.length; i++) {
      indexes[i] = i;
    }
    Arrays.sort(indexes, Comparator.comparingInt(a -> queries[a][1]));
    int index = 0;
    int[] result = new int[queries.length];
    for (int i = 0; i < queries.length; i++) {
      while (index < nums.length && nums[index] <= queries[indexes[i]][1]) {
        trie.insert(nums[index++]);
      }
      result[indexes[i]] = index == 0 ? -1 : trie.search(queries[indexes[i]][0]);
    }
    return result;
  }

}