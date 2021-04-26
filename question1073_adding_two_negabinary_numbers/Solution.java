package question1073_adding_two_negabinary_numbers;

public class Solution {

  public int[] addNegabinary(int[] arr1, int[] arr2) {
    if (arr1[0] == 0) {
      return arr2;
    }
    if (arr2[0] == 0) {
      return arr1;
    }
    int len1 = arr1.length, len2 = arr2.length, len = Math.max(len1, len2) + 2;
    int[] ans = new int[len];
    int cur = len, temp = len - 1;
    while (len1 >= 1 || len2 >= 1 || cur >= 1) {
      if (len1 >= 1) {
        ans[cur - 1] += arr1[len1 - 1];
        len1--;
      }
      if (len2 >= 1) {
        ans[cur - 1] += arr2[len2 - 1];
        len2--;
      }
      while (ans[cur - 1] < 0) {
        ans[cur - 1] = ans[cur - 1] + 2;
        ans[cur - 2]++;
      }
      while (ans[cur - 1] > 1) {
        ans[cur - 1] -= 2;
        ans[cur - 2]--;
      }
      cur--;
    }
    for (int i = 0; i < len; i++) {
      if (ans[i] == 1) {
        temp = i;
        break;
      }
    }
    int[] result = new int[len - temp];
    for (int i = 0, j = temp; j < len; j++, i++) {
      result[i] = ans[j];
    }
    return result;
  }

}