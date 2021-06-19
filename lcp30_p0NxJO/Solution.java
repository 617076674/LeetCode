package lcp30_p0NxJO;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {

  public static void main(String[] args) {
    int[] nums = {-200,-300,400,0};
    System.out.println(new Solution().magicTower(nums));
  }

  public int magicTower(int[] nums) {
    long hp = 1;
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
    List<Integer> last = new ArrayList<>();
    for (int num : nums) {
      if (num >= 0) {
        hp += num;
      } else {
        if (hp > -num) {
          hp += num;
          priorityQueue.add(num);
        } else {
          hp += num;
          priorityQueue.add(num);
          while (hp <= 0) {
            if (priorityQueue.isEmpty()) {
              return -1;
            }
            int temp = priorityQueue.poll();
            hp -= temp;
            last.add(temp);
          }
        }
      }
    }
    for (int i = 0; i < last.size(); i++) {
      hp += last.get(i);
    }
    return hp > 0 ? last.size() : -1;
  }

}