package question1352_product_of_the_last_k_numbers;

public class ProductOfNumbers {

  private int[] multiple = new int[40001];

  private int len;

  public ProductOfNumbers() {
    multiple[0] = 1;
  }

  public void add(int num) {
    if (num == 0) {
      len = 0;
    } else {
      multiple[++len] = num;
      multiple[len] *= multiple[len - 1];
    }
  }

  public int getProduct(int k) {
    if (len < k) {
      return 0;
    }
    return multiple[len] / multiple[len - k];
  }

}