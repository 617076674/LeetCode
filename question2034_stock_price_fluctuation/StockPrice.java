package question2034_stock_price_fluctuation;

import java.util.TreeMap;

public class StockPrice {

  private TreeMap<Integer, Integer> time2Price = new TreeMap<>(), price2Count = new TreeMap<>();

  public StockPrice() {
  }

  public void update(int timestamp, int price) {
    Integer originPrice = time2Price.get(timestamp);
    if (null != originPrice) {
      Integer originCount = price2Count.get(originPrice);
      if (1 == originCount) {
        price2Count.remove(originPrice);
      } else {
        price2Count.put(originPrice, originCount - 1);
      }
    }
    price2Count.put(price, price2Count.getOrDefault(price, 0) + 1);
    time2Price.put(timestamp, price);
  }

  public int current() {
    return time2Price.lastEntry().getValue();
  }

  public int maximum() {
    return price2Count.lastKey();
  }

  public int minimum() {
    return price2Count.firstKey();
  }

}