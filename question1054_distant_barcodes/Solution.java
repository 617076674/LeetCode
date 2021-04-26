package question1054_distant_barcodes;

import java.util.PriorityQueue;

public class Solution {

  public int[] rearrangeBarcodes(int[] barcodes) {
    int[] map = new int[10001], result = new int[barcodes.length];
    for (int barcode : barcodes) {
      map[barcode]++;
    }
    PriorityQueue<Integer> queue = new PriorityQueue<>((code1, code2) -> map[code2] - map[code1]);
    for (int i = 0; i < map.length; i++) {
      if (map[i] != 0) {
        queue.offer(i);
      }
    }
    int index = 0;
    while (queue.size() > 1) {
      int code1 = queue.poll(), code2 = queue.poll();
      result[index++] = code1;
      result[index++] = code2;
      if (map[code1] > 1) {
        map[code1]--;
        queue.offer(code1);
      }
      if (map[code2] > 1) {
        map[code2]--;
        queue.offer(code2);
      }
    }
    if (!queue.isEmpty()) {
      result[index] = queue.poll();
    }
    return result;
  }

}