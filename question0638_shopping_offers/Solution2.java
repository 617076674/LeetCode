package question0638_shopping_offers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 记忆化搜索。
 *
 * 执行用时：10ms，击败63.96%。消耗内存：40MB，击败100.00%。
 */
public class Solution2 {
    private Map<List<Integer>, Integer> memo = new HashMap<>();

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        if (memo.containsKey(needs)) {
            return memo.get(needs);
        }
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
        memo.put(needs, result);
        return result;
    }
}