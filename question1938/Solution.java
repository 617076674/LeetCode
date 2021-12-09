package question1938;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

  private static class Trie {
    private static class TrieNode {
      TrieNode[] children = new TrieNode[2];
      Integer val;
      int[] count = new int[2];
    }

    private TrieNode root = new TrieNode();

    public void insert(int num) {
      TrieNode cur = root;
      for (int i = 31; i >= 0; i--) {
        int digit = (num & (1 << i)) == 0 ? 0 : 1;
        if (cur.children[digit] == null) {
          cur.children[digit] = new TrieNode();
        }
        cur.count[digit]++;
        cur = cur.children[digit];
      }
      cur.val = num;
    }

    public int find(int num) {
      TrieNode cur = root;
      for (int i = 31; i >= 0; i--) {
        int digit = (num & (1 << i)) == 0 ? 0 : 1;
        if (null != cur.children[1 - digit] && cur.count[1 - digit] > 0) {
          cur = cur.children[1 - digit];
        } else {
          cur = cur.children[digit];
        }
      }
      return cur.val;
    }

    public void remove(int num) {
      TrieNode cur = root;
      for (int i = 31; i >= 0; i--) {
        int digit = (num & (1 << i)) == 0 ? 0 : 1;
        cur.count[digit]--;
        cur = cur.children[digit];
      }
      cur.val = null;
    }
  }

  private static class TreeNode {
    int val;
    List<TreeNode> children = new ArrayList<>();

    public TreeNode(int val) {
      this.val = val;
    }
  }

  private Trie trie = new Trie();

  private Map<Integer, Map<Integer, Integer>> node2Val2Result = new HashMap<>();

  public int[] maxGeneticDifference(int[] parents, int[][] queries) {
    Map<Integer, TreeNode> val2TreeNode = new HashMap<>();
    for (int i = 0; i < parents.length; i++) {
      val2TreeNode.put(i, new TreeNode(i));
    }
    int rootVal = -1;
    for (int i = 0; i < parents.length; i++) {
      if (parents[i] != -1) {
        val2TreeNode.get(parents[i]).children.add(val2TreeNode.get(i));
      } else {
        rootVal = i;
      }
    }
    TreeNode root = val2TreeNode.get(rootVal);
    for (int[] query : queries) {
      Map<Integer, Integer> val2Result = node2Val2Result.get(query[0]);
      if (null == val2Result) {
        val2Result = new HashMap<>();
        val2Result.put(query[1], null);
        node2Val2Result.put(query[0], val2Result);
      } else {
        val2Result.put(query[1], null);
      }
    }
    dfs(root);
    int[] result = new int[queries.length];
    for (int i = 0; i < queries.length; i++) {
      result[i] = node2Val2Result.get(queries[i][0]).get(queries[i][1]);
    }
    return result;
  }

  public static void main(String[] args) {
//    int[] parents = {-1,0,1,1};
//    int[][] queries = {{0,2},{3,2},{2,5}};
    int[] parents = {3,7,-1,2,0,7,0,2};
    int[][] queries = {{4,6},{1,15},{0,5}};
    // [2, 3, 7]
    // [6, 14, 7]
    System.out.println(Arrays.toString(new Solution().maxGeneticDifference(parents, queries)));
  }

  private void dfs(TreeNode treeNode) {
    if (null == treeNode) {
      return;
    }
    trie.insert(treeNode.val);
    Map<Integer, Integer> val2Result = node2Val2Result.get(treeNode.val);
    if (null != val2Result) {
      Map<Integer, Integer> realVal2Result = new HashMap<>();
      for (int val : val2Result.keySet()) {
        realVal2Result.put(val, trie.find(val) ^ val);
      }
      node2Val2Result.put(treeNode.val, realVal2Result);
    }
    if (null != treeNode.children) {
      for (TreeNode child : treeNode.children) {
        dfs(child);
      }
    }
    trie.remove(treeNode.val);
  }

}