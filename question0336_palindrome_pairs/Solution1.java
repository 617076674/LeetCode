package question0336_palindrome_pairs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 字典树。
 *
 * 对于某个字符 s，将其拆分为两部分，s1 和 s2，其中 s1 是回文串，s2 不是回文串。
 *
 * 若 s = s1 + s2，那么只需要在 s 前面拼接上 s2 的逆序即可。
 * 若 s = s2 + s1，那么只需要在 s 后面拼接上 s2 的逆序即可。
 *
 * 对于 words 数组中的每一个字符串 words[i]，遍历所有的前缀和后缀回文串，并利用字典树寻找 s2 的逆序。
 *
 * 时间复杂度是 O(n * m ^ 2)，其中 n 为数组 words 的长度，m 为字符串的平均长度。
 *
 * 执行用时：43ms，击败97.37%。消耗内存：48.3MB，击败18.74%。
 */
public class Solution1 {
  private class TrieNode {
    private TrieNode[] next = new TrieNode[26];
    private int flag;

    public TrieNode() {
      flag = -1;
    }
  }

  private TrieNode trieNode = new TrieNode();

  public List<List<Integer>> palindromePairs(String[] words) {
    int n = words.length;
    for (int i = 0; i < n; i++) {
      insert(words[i], i);
    }
    List<List<Integer>> result = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      int m = words[i].length();
      for (int j = 0; j <= m; j++) {
        if (isPalindrome(words[i], j, m - 1)) {
          int leftId = findWord(words[i], 0, j - 1);
          if (leftId != -1 && leftId != i) {
            result.add(Arrays.asList(i, leftId));
          }
        }
        if (j != 0 && isPalindrome(words[i], 0, j - 1)) {
          int rightId = findWord(words[i], j, m - 1);
          if (rightId != -1 && rightId != i) {
            result.add(Arrays.asList(rightId, i));
          }
        }
      }
    }
    return result;
  }

  public void insert(String s, int id) {
    TrieNode cur = trieNode;
    for (int i = 0; i < s.length(); i++) {
      int num = s.charAt(i) - 'a';
      if (cur.next[num] == null) {
        cur.next[num] = new TrieNode();
      }
      cur = cur.next[num];
    }
    cur.flag = id;
  }

  public boolean isPalindrome(String s, int left, int right) {
    while (left < right) {
      if (s.charAt(left++) != s.charAt(right--)) {
        return false;
      }
    }
    return true;
  }

  public int findWord(String s, int left, int right) {
    TrieNode cur = trieNode;
    for (int i = right; i >= left; i--) {
      int num = s.charAt(i) - 'a';
      if (cur.next[num] == null) {
        return -1;
      }
      cur = cur.next[num];
    }
    return cur.flag;
  }
}