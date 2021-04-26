package question1169_invalid_transactions;

import java.util.ArrayList;
import java.util.List;

public class Solution {

  public List<String> invalidTransactions(String[] transactions) {
    List<String[]> storge = new ArrayList<>();
    List<String> result = new ArrayList<>();
    boolean[] inResult = new boolean[transactions.length];
    for (String transaction : transactions) {
      storge.add(transaction.split(","));
    }
    for (int i = 0; i < transactions.length; i++) {
      String[] transaction1 = storge.get(i);
      String name = transaction1[0];
      String city = transaction1[3];
      int time = Integer.parseInt(transaction1[1]);
      if (Integer.parseInt(transaction1[2]) > 1000 && !inResult[i]) {
        result.add(transactions[i]);
        inResult[i] = true;
      }
      for (int j = i + 1; j < transactions.length; j++) {
        String[] transaction2 = storge.get(j);
        if (name.equals(transaction2[0]) && Math.abs(time - Integer.parseInt(transaction2[1])) <= 60 && !city.equals(transaction2[3])) {
          if (!inResult[j]) {
            result.add(transactions[j]);
            inResult[j] = true;
          }
          if (!inResult[i]) {
            result.add(transactions[i]);
            inResult[i] = true;
          }
        }
      }
    }
    return result;
  }

}