package question0854_k_similar_strings;

public class Solution {

  private int result = Integer.MAX_VALUE;

  public int kSimilarity(String s1, String s2) {
    doSelect(s1.toCharArray(), s2.toCharArray(), s1.length(), 0, 0);
    return result;
  }

  private void doSelect(char[] recordA, char[] recordB, int len, int curCount, int curIndex) {
    if (curCount > result) {
      return;
    }
    if (curIndex == len) {
      result = Math.min(result, curCount);
      return;
    }
    int i = curIndex;
    for (; i < len; i++) {
      if (recordA[i] == recordB[i]) {
        doSelect(recordA, recordB, len, curCount, curIndex + 1);
      } else {
        int k = i + 1;
        for (; k < len; k++) {
          if (recordA[i] == recordB[k]) {
            swap(recordB, i, k);
            doSelect(recordA, recordB, len, curCount + 1, i + 1);
            swap(recordB, i, k);
          }
        }
      }
    }
  }

  private void swap(char[] arr, int i, int j) {
    char temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static void main(String[] args) {
    System.out.println(new Solution().kSimilarity("abac", "baca"));
  }

}