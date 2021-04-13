package question0911_online_election;

import java.util.ArrayList;
import java.util.List;

public class TopVotedCandidate {

  private static class Vote {
    int person;
    int time;

    Vote(int p, int t) {
      person = p;
      time = t;
    }
  }

  private List<Vote> leaderChanges = new ArrayList<>();

  public TopVotedCandidate(int[] persons, int[] times) {
    int[] map = new int[5001];
    int leader = -1, max = 0;

    for (int i = 0; i < persons.length; i++) {
      int p = persons[i], t = times[i];
      int c = ++map[p];
      if (c >= max) {
        if (p != leader) {
          leader = p;
          leaderChanges.add(new Vote(leader, t));
        }
        if (c > max) {
          max = c;
        }
      }
    }
  }

  public int q(int t) {
    int left = 0, right = leaderChanges.size() - 1;
    while (left < right) {
      if (left + 1 == right) {
        if (leaderChanges.get(right).time <= t) {
          return leaderChanges.get(right).person;
        }
        return leaderChanges.get(left).person;
      }
      int mid = left + ((right - left) >> 1);
      if (leaderChanges.get(mid).time == t) {
        return leaderChanges.get(mid).person;
      } else if (leaderChanges.get(mid).time > t) {
        right = mid - 1;
      } else {
        left = mid;
      }
    }
    return leaderChanges.get(left).person;
  }

}