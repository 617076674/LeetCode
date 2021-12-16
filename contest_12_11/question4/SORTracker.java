package contest_12_11.question4;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SORTracker {

  private int queryCnt = 1;

  private Map<String, Integer> name2Score = new HashMap<>();

  private PriorityQueue<String> minPQ = new PriorityQueue<>((name1, name2) -> {
    int score1 = name2Score.get(name1), score2 = name2Score.get(name2);
    if (score1 == score2) {
      return name2.compareTo(name1);
    }
    return score1 - score2;
  });

  private PriorityQueue<String> maxPQ = new PriorityQueue<>((name1, name2) -> {
    int score1 = name2Score.get(name1), score2 = name2Score.get(name2);
    if (score1 == score2) {
      return name1.compareTo(name2);
    }
    return score2 - score1;
  });

  public SORTracker() {

  }

  public void add(String name, int score) {
    name2Score.put(name, score);
    if (minPQ.isEmpty()) {
      minPQ.add(name);
      return;
    }
    String minPQTop = minPQ.peek();
    int tempScore = name2Score.get(minPQTop);
    if (tempScore < score || (score == tempScore && name.compareTo(minPQTop) < 0) || minPQ.size() < queryCnt) {
      minPQ.add(name);
      if (minPQ.size() > queryCnt) {
        maxPQ.add(minPQ.poll());
      }
    } else {
      maxPQ.add(name);
    }
  }

  public String get() {
    String result = minPQ.peek();
    if (!maxPQ.isEmpty()) {
      minPQ.add(maxPQ.poll());
    }
    queryCnt++;
    return result;
  }

}
