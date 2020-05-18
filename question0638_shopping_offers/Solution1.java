package question0638_shopping_offers;

import java.util.ArrayList;
import java.util.List;

/**
 * 递归。
 *
 * 执行用时：13ms，击败36.75%。消耗内存：39.7MB，击败100.00%。
 */
public class Solution1 {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        if (needs.stream().allMatch(need -> need == 0)) {
            return 0;
        }
        // 不使用任何大礼包
        int result = 0;
        for (int i = 0; i < price.size(); i++) {
            result += price.get(i) * needs.get(i);
        }
        // 使用大礼包
        for (int i = 0; i < special.size(); i++) {
            List<Integer> gift = special.get(i), newNeeds = new ArrayList<>(needs);
            boolean canBuy = true;
            for (int j = 0; j < gift.size() - 1; j++) {
                if (newNeeds.get(j) - gift.get(j) < 0) {
                    canBuy = false;
                    break;
                }
                newNeeds.set(j, newNeeds.get(j) - gift.get(j));
            }
            if (canBuy) {
                result = Math.min(result, gift.get(gift.size() - 1) + shoppingOffers(price, special, newNeeds));
            }
        }
        return result;
    }
}