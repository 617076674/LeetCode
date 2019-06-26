package question122;

public class Solution {
    public int maxProfit(int[] prices) {
        int result = 0;
        int buy, sell;
        for (int i = 0; i < prices.length; i++) {
            while (i + 1 < prices.length && prices[i + 1] <= prices[i]) {
                i++;
            }
            buy = i;
            for (sell = buy + 1; sell < prices.length; sell++) {
                if (prices[sell] > prices[buy]) {
                    if (sell + 1 < prices.length) {
                        if (prices[sell + 1] < prices[sell]) {
                            result += prices[sell] - prices[buy];
                            i = sell;
                            break;
                        }
                    } else {
                        result += prices[sell] - prices[buy];
                        i = sell;
                        break;
                    }
                }
            }
        }
        return result;
    }
}
