package question0866_prime_palindrome;

public class Solution {

  public int primePalindrome(int N) {
    for (int L = 1; L <= 5; L++) {
      for (int root = (int) Math.pow(10, L - 1); root < (int) Math.pow(10, L); root++) {
        StringBuilder sb = new StringBuilder(Integer.toString(root));
        for (int k = L - 2; k >= 0; k--) {
          sb.append(sb.charAt(k));
        }
        int x = Integer.parseInt(sb.toString());
        if (x >= N && isPrime(x)) {
          return x;
        }
      }
      for (int root = (int) Math.pow(10, L - 1); root < (int) Math.pow(10, L); root++) {
        StringBuilder sb = new StringBuilder(Integer.toString(root));
        for (int k = L - 1; k >= 0; k--) {
          sb.append(sb.charAt(k));
        }
        int x = Integer.parseInt(sb.toString());
        if (x >= N && isPrime(x)) {
          return x;
        }
      }
    }
    return -1;
  }

  public boolean isPrime(int num) {
    if (num < 2) {
      return false;
    }
    int right = (int) Math.sqrt(num);
    for (int i = 2; i <= right; i++) {
      if (num % i == 0) {
        return false;
      }
    }
    return true;
  }

}