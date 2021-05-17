package question1432_max_difference_you_can_get_from_changing_an_integer;

public class Solution {

  public int maxDiff(int num) {
    char[] chars = (num + "").toCharArray();
    char target = 'a';
    for (char c : chars) {
      if (c != '9') {
        target = c;
        break;
      }
    }
    int max = 0;
    if (target != 'a') {
      for (char c : chars) {
        if (c == target) {
          max = max * 10 + 9;
        } else {
          max = max * 10 + c - '0';
        }
      }
    } else {
      max = num;
    }
    int min = 0;
    if (chars[0] == '1') {
      target = 'a';
      for (char c : chars) {
        if (c != '0' && c != '1') {
          target = c;
          break;
        }
      }
      for (char c : chars) {
        if (c == target) {
          min = min * 10;
        } else {
          min = min * 10 + c - '0';
        }
      }
    } else {
      target = chars[0];
      for (char c : chars) {
        if (c == target) {
          min = min * 10 + 1;
        } else {
          min = min * 10 + c - '0';
        }
      }
    }
    return max - min;
  }

}