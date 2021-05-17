package question1357_apply_discount_every_n_orders;

public class Cashier {

  private int[] map = new int[201];

  private int count, discount, n;

  public Cashier(int n, int discount, int[] products, int[] prices) {
    this.discount = discount;
    this.n = n;
    for (int i = 0; i < products.length; i++) {
      map[products[i]] = prices[i];
    }
  }

  public double getBill(int[] product, int[] amount) {
    count++;
    double result = 0.0;
    for (int i = 0; i < product.length; i++) {
      result += map[product[i]] * amount[i];
    }
    if (count == n) {
      count = 0;
      result -= result * discount / 100.0;
    }
    return result;
  }

}