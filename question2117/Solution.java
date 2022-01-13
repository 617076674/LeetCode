package question2117;

public class Solution {

  private static final int MOD1 = 100000;

  private static final int MOD2 = 1000000000;

  private static final Long MAX = 10000000000L;

  public String abbreviateProduct(int left, int right) {
    int count20 = count(left - 1, 2), count21 = count(right, 2);
    int count50 = count(left - 1, 5), count51 = count(right, 5);
    int count2 = count21 - count20, count5 = count51 - count50;
    int c = Math.min(count2, count5);
    count2 -= c;
    count5 -= c;
    double total = 1.0;
    long result = 1L;
    boolean flag = true;
    while (count2 > 0) {
      result *= 2;
      if (total >= MAX) {
        flag = false;
      }
      total *= 2;
      result %= MOD1;
      count2--;
    }
    while (count5 > 0) {
      result *= 5;
      total *= 5;
      if (total >= MAX) {
        flag = false;
      }
      result %= MOD1;
      count5--;
    }
    long tempResult = result;
    if (flag) {
      for (int i = left; i <= right; i++) {
        long num = i;
        while (num % 2 == 0) {
          num /= 2;
        }
        while (num % 5 == 0) {
          num /= 5;
        }
        total *= num;
        if (total >= MAX) {
          flag = false;
          break;
        }
        result *= num;
      }
    }
    if (flag) {
      return result + "e" + c;
    }
    total = 1.0;
    result = tempResult;
    for (int i = left; i <= right; i++) {
      long num = i;
      while (num % 2 == 0) {
        num /= 2;
      }
      while (num % 5 == 0) {
        num /= 5;
      }
      total *= i;
      if (total > MOD2) {
        total /= MOD2;
      }
      result *= num % MOD1;
      result %= MOD1;
    }
    String s1 = String.valueOf(total);
    String finalResult = "";
    int index = 0;
    while (finalResult.length() < 5) {
      if (Character.isDigit(s1.charAt(index))) {
        finalResult += s1.charAt(index);
      }
      index++;
    }
    String resultStr = String.valueOf(result);
    while (resultStr.length() < 5) {
      resultStr = "0" + resultStr;
    }
    return finalResult + "..." + resultStr + "e" + c;
  }

  private static int count(int n, int digit) {
    int result = 0;
    while (n > 0) {
      result += n / digit;
      n /= digit;
    }
    return result;
  }

}
