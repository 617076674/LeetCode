package question1606;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {

  public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
    int[] availableTime = new int[k];
    int[] solved = new int[k];
    List<Integer> availableList = new ArrayList<>();
    for (int i = 0; i < k; i++) {
      availableList.add(i);
    }
    PriorityQueue<Integer> priorityQueue =
        new PriorityQueue<>(Comparator.comparingInt(index -> availableTime[index]));
    int max = 0;
    for (int i = 0; i < arrival.length; i++) {
      while (!priorityQueue.isEmpty() && arrival[i] >= availableTime[priorityQueue.peek()]) {
        insert(priorityQueue.poll(), availableList);
      }
      int index = findRealTarget(i % k, availableList);
      if (-1 == index) {
        continue;
      }
      int realTarget = availableList.remove(index);
      max = Math.max(++solved[realTarget], max);
      availableTime[realTarget] = arrival[i] + load[i];
      priorityQueue.add(realTarget);
    }
    List<Integer> result = new ArrayList<>();
    for (int i = 0; i < k; i++) {
      if (solved[i] == max) {
        result.add(i);
      }
    }
    return result;
  }

  private void insert(int num, List<Integer> availableList) {
    int insertIndex = searchInsert(availableList, num);
    if (insertIndex == availableList.size()) {
      availableList.add(num);
    } else {
      availableList.add(insertIndex, num);
    }
  }

  private int searchInsert(List<Integer> availableList, int target) {
    int left = 0, right = availableList.size() - 1;
    while (left <= right) {
      int mid = left + ((right - left) >> 1);
      if (target == availableList.get(mid)) {
        left = mid + 1;
      } else if (target < availableList.get(mid)) {
        right = mid - 1;
      } else if (target > availableList.get(mid)) {
        left = mid + 1;
      }
    }
    if (right < 0 || availableList.get(right) != target) {
      return right + 1;
    }
    return right;
  }

  // 在 availableList 中寻找到第一个大于等于 target 的 index
  private int findRealTarget(int target, List<Integer> availableList) {
    if (availableList.isEmpty()) {
      return -1;
    }
    if (availableList.get(availableList.size() - 1) < target) {
      return 0;
    }
    int left = 0, right = availableList.size() - 1;
    while (left < right) {
      if (left + 1 == right) {
        if (availableList.get(left) >= target) {
          return left;
        }
        if (availableList.get(right) >= target) {
          return right;
        }
        return left;
      }
      int mid = left + ((right - left) >> 1);
      if (availableList.get(mid) == target) {
        return mid;
      }
      if (availableList.get(mid) > target) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    return left;
  }

}