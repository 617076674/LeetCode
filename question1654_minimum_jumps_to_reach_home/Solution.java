package question1654_minimum_jumps_to_reach_home;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.StampedLock;

/**
 * 深搜。
 *
 * 执行用时：15ms，击败86.65%。消耗内存：39.3MB，击败31.15%。
 */
public class Solution {

    private Set<Integer> forbiddenSet = new HashSet<>();

    private int result = -1;

    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        for (int num : forbidden) {
            forbiddenSet.add(num);
        }
        minimumJumps(0, a, b, x, 0, 0);
        return result;
    }

    public static void main(String[] args) throws InterruptedException {
        StampedLock stampedLock = new StampedLock();
        Thread t1 = new Thread(() -> {
            long readStamped1 = stampedLock.readLock();
            System.out.println("t1 加锁成功");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            stampedLock.unlockRead(readStamped1);
        }, "t1");
        t1.start();
        Thread.sleep(500);
        long writeStamped1 = stampedLock.writeLock();
        System.out.println();
    }

    private static final long INTERRUPTED = 1L;

    private static final int CANCELLED =  1;



    private void minimumJumps(int now, int a, int b, int x, int pre, int step) {
        if (result >= 0 || now >= 6000 || now < 0) {
            return;
        }
        if (x == now) {
            result = step;
            return;
        }
        if (!forbiddenSet.contains(a + now)) {
            forbiddenSet.add(a + now);
            minimumJumps(a + now, a, b, x, 1, step + 1);
        }
        if (pre >= 0 && !forbiddenSet.contains(now - b)) {
            // 为什么回退不需要加进 forbiddenSet 呢？因为题目规定了不能连续回退 2 次！
            // 即左移后退回位置 p 时，无法覆盖先前进至位置 p，再回退至 (p - b) 的情况！
            minimumJumps(now - b, a, b, x, -1, step + 1);
        }
    }

}