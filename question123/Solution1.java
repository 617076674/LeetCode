package question123;

public class Solution1 {
    public int maxProfit(int[] prices) {
        int result = 0;
        if(prices.length == 0){
            return result;
        }
        int firstDealSell;  //第一笔交易在firstDealSell卖出
        int secondDealSell; //第二笔交易在secondDealSell卖出
        for(secondDealSell = prices.length - 1; secondDealSell > 0; secondDealSell--){
            if(prices[secondDealSell - 1] < prices[secondDealSell]){
                break;
            }
        }
        for(firstDealSell = 1; firstDealSell < prices.length; firstDealSell++){
            while(firstDealSell + 1 < prices.length && prices[firstDealSell + 1] >= prices[firstDealSell]){
                firstDealSell++;
            }
            int result1 = maxProfit(prices, 0, firstDealSell);
            int result2 = maxProfit(prices, firstDealSell + 1, secondDealSell);
            if(result1 + result2 > result){
                result = result1 + result2;
            }
        }
        return result;
    }

    private int maxProfit(int[] prices, int left, int right){
        int result = 0;
        if(right - left < 1){
            return result;
        }
        int minPrice = prices[left];
        for(int i = left + 1; i <= right; i++){
            result = Math.max(result, prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }
        return result;
    }
}