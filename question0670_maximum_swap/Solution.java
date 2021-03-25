package question0670_maximum_swap;

public class Solution {

  public int maximumSwap(int num) {
      char[] arr = Integer.toString(num).toCharArray();
      for (int i = 0; i < arr.length; i++) {
          int index = -1;
          char max = arr[i];
          for (int j = i + 1; j < arr.length; j++) {
              if (arr[j] >= max) {
                  index = j;
                  max = arr[j];
              }
          }
          if (index != -1 && max != arr[i]) {
              char temp = arr[i];
              arr[i] = arr[index];
              arr[index] = temp;
              return Integer.parseInt(new String(arr));
          }
      }
      return num;
  }

}