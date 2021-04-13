package question0900_rle_iterator;

public class RLEIterator {

  private int[] A;

  private int i, q;

  public RLEIterator(int[] A) {
    this.A = A;
  }

  public int next(int n) {
    while (i < A.length) {
      if (q + n > A[i]) {
        n -= A[i] - q;
        q = 0;
        i += 2;
      } else {
        q += n;
        return A[i + 1];
      }
    }
    return -1;
  }
}