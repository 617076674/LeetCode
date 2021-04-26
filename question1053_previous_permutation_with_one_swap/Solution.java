package question1053_previous_permutation_with_one_swap;

public class Solution {

  public int[] prevPermOpt1(int[] arr) {
    if (null == arr || arr.length <= 1) {
      return arr;
    }
    int i = arr.length - 1;
    while (i - 1 >= 0 && arr[i - 1] <= arr[i]) {
      i--;
    }
    if (i - 1 < 0) {
      return arr;
    }
    i--;
    int j = arr.length - 1;
    while (j > i && arr[j] >= arr[i]) {
      j--;
    }
    while (j - 1 > i && arr[j - 1] == arr[j]) {
      j--;
    }
    swap(arr, i, j);
    return arr;
  }

  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

}