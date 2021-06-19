package question1882_process_tasks_using_servers;

import java.util.PriorityQueue;

public class Solution {

  private static class BusyServer {
    int t, idx;

    public BusyServer(int t, int idx) {
      this.t = t;
      this.idx = idx;
    }
  }

  private static class IdleServer {
    int w, idx;

    public IdleServer(int w, int idx) {
      this.w = w;
      this.idx = idx;
    }
  }

  public int[] assignTasks(int[] servers, int[] tasks) {
    int ts = 0;
    PriorityQueue<BusyServer> busyPQ = new PriorityQueue<>((busyServer1, busyServer2) -> {
      if (busyServer1.t == busyServer2.t) {
        return busyServer1.idx - busyServer2.idx;
      }
      return busyServer1.t - busyServer2.t;
    });
    PriorityQueue<IdleServer> idlePQ = new PriorityQueue<>((idleServer1, idleServer2) -> {
      if (idleServer1.w == idleServer2.w) {
        return idleServer1.idx - idleServer2.idx;
      }
      return idleServer1.w - idleServer2.w;
    });
    for (int i = 0; i < servers.length; i++) {
      idlePQ.add(new IdleServer(servers[i], i));
    }
    int[] result = new int[tasks.length];
    for (int i = 0; i < tasks.length; i++) {
      ts = Math.max(ts, i);
      while (!busyPQ.isEmpty() && busyPQ.peek().t <= ts) {
        BusyServer busyServer = busyPQ.poll();
        idlePQ.add(new IdleServer(servers[busyServer.idx], busyServer.idx));
      }
      if (idlePQ.isEmpty()) {
        ts = busyPQ.peek().t;
        while (!busyPQ.isEmpty() && busyPQ.peek().t <= ts) {
          BusyServer busyServer = busyPQ.poll();
          idlePQ.add(new IdleServer(servers[busyServer.idx], busyServer.idx));
        }
      }
      result[i] = idlePQ.peek().idx;
      IdleServer idleServer = idlePQ.poll();
      busyPQ.add(new BusyServer(ts + tasks[i], idleServer.idx));
    }
    return result;
  }

}