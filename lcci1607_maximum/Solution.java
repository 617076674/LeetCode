package lcci1607_maximum;

public class Solution {

  public int maximum(int a, int b) {
    return (int) (((long) a + b + Math.abs((long) a - b)) / 2);
  }

}