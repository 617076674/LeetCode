package question1801_number_of_orders_in_the_backlog;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

    private static final int MOD = 1000000007;

    public int getNumberOfBacklogOrders(int[][] orders) {
        PriorityQueue<int[]> sellBacklog =
            new PriorityQueue<>(Comparator.comparingInt(backlog -> backlog[0])),
            buyBacklog = new PriorityQueue<>((backlog1, backlog2) -> backlog2[0] - backlog1[0]);
        for (int[] order : orders) {
            if (order[2] == 0) {
                // buy order
                boolean need = true;
                while (!sellBacklog.isEmpty() && sellBacklog.peek()[0] <= order[0]) {
                    if (sellBacklog.peek()[1] == order[1]) {
                        sellBacklog.poll();
                        need = false;
                        break;
                    } else if (sellBacklog.peek()[1] > order[1]) {
                        sellBacklog.peek()[1] -= order[1];
                        need = false;
                        break;
                    } else {
                        order[1] -= sellBacklog.poll()[1];
                    }
                }
                if (need) {
                    buyBacklog.add(new int[] {order[0], order[1]});
                }
            } else {
                // sell order
                boolean need = true;
                while (!buyBacklog.isEmpty() && buyBacklog.peek()[0] >= order[0]) {
                    if (buyBacklog.peek()[1] == order[1]) {
                        buyBacklog.poll();
                        need = false;
                        break;
                    } else if (buyBacklog.peek()[1] > order[1]) {
                        buyBacklog.peek()[1] -= order[1];
                        need = false;
                        break;
                    } else {
                        order[1] -= buyBacklog.poll()[1];
                    }
                }
                if (need) {
                    sellBacklog.add(new int[] {order[0], order[1]});
                }
            }
        }
        int result = 0;
        while (!sellBacklog.isEmpty()) {
            result += sellBacklog.poll()[1];
            result %= MOD;
        }
        while (!buyBacklog.isEmpty()) {
            result += buyBacklog.poll()[1];
            result %= MOD;
        }
        return result;
    }

}