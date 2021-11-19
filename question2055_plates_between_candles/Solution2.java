package question2055_plates_between_candles;

/**
 * s的形式如  |***|*|****||*
 * 要找给定区间[q1, q2]上一共有多少个介于｜之间的*
 * 区间的大小确定的情况下，该区间一共有 q1 - q2 + 1个字符
 *
 * 区间原始的边界left,right确定的子串并非刚好是|
 * 可能是|***|； ***|*；***|*|*；|***|*；***|*|；|***|*|****|；*** 等
 * 没有被|包围的*不记，因此需要找到[q1, q2]真正的边界left和right
 * left是[q1, q2]上第一个｜的索引，right则是[q1, q2]最后一个｜的索引
 * 而当left >= right时，说明不存在介于｜之间的*
 * 否则，存在这样的*，一个区间内，统计有多少个*
 *
 * 所以
 * 要快速统计区间内有多少个*，使用前缀和
 * 要快速知道left，right，就需要缓存每一个索引前后最近的|的索引，可以使用int[]来代替hashmap做映射
 * 如果某个字符就是|，那么前后最近的|的索引就是它本身
 * 如果某个字符没有前置的|，那么设置其前面最近的索引为-1
 * 如果某个字符没有后置的|，那么设置其前面最近的索引为n
 *
 * 执行用时：7 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：86.7 MB, 在所有 Java 提交中击败了100.00%的用户
 */
public class Solution2 {

  public int[] platesBetweenCandles(String s, int[][] queries) {
    int[] sums = new int[s.length() + 1], before = new int[s.length()], after = new int[s.length()];
    for (int i = 1; i < sums.length; i++) {
      sums[i] = s.charAt(i - 1) == '*' ? sums[i - 1] + 1 : sums[i - 1];
    }
    for (int i = 0, pre = -1; i < s.length(); i++) {
      if (s.charAt(i) == '|') {
        pre = i;
      }
      before[i] = pre;
    }
    for (int i = s.length() - 1, next = s.length(); i >= 0; i--) {
      if (s.charAt(i) == '|') {
        next = i;
      }
      after[i] = next;
    }
    int[] res = new int[queries.length];
    for (int i = 0; i < queries.length; i++) {
      int[] cur = queries[i];
      int left = after[cur[0]], right = before[cur[1]];
      if (left < right) {
        res[i] = sums[right + 1] - sums[left]; // 前缀和与索引是错位的
      }
    }
    return res;
  }

}