package question2166;

public class Bitset {

  private int size;

  private int countOne;

  private int[] status;

  private int flipCnt;

  public Bitset(int size) {
    this.size = size;
    this.status = new int[size];
  }

  public void fix(int idx) {
    if (status[idx] == 0 && flipCnt % 2 == 0) {
      status[idx] = 1;
      countOne++;
    } else if (status[idx] == 1 && flipCnt % 2 == 1) {
      status[idx] = 0;
      countOne++;
    }
  }

  public void unfix(int idx) {
    if (status[idx] == 1 && flipCnt % 2 == 0) {
      status[idx] = 0;
      countOne--;
    } else if (status[idx] == 0 && flipCnt % 2 == 1) {
      status[idx] = 1;
      countOne--;
    }
  }

  public void flip() {
    flipCnt++;
    countOne = size - countOne;
  }

  public boolean all() {
    return countOne == size;
  }

  public boolean one() {
    return countOne > 0;
  }

  public int count() {
    return countOne;
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < size; i++) {
      if (flipCnt % 2 == 0) {
        sb.append(status[i]);
      } else {
        sb.append(1 - status[i]);
      }
    }
    return sb.toString();
  }

}