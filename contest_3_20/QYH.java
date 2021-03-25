package contest_3_20;

public class QYH {
  private static final int COUNT_BITS = Integer.SIZE - 3;
  private static final int CAPACITY   = (1 << COUNT_BITS) - 1;

  // runState is stored in the high-order bits
  private static final int RUNNING    = -1 << COUNT_BITS;

  private static final int SHUTDOWN   =  0 << COUNT_BITS;

  private static final int STOP       =  1 << COUNT_BITS;

  private static final int TIDYING    =  2 << COUNT_BITS;

  private static final int TERMINATED =  3 << COUNT_BITS;

  public static void main(String[] args) {
    System.out.println("COUNT_BITS = \t" + COUNT_BITS + "(" + Integer.toBinaryString(COUNT_BITS) + ")");
    System.out.println("CAPACITY = \t" + CAPACITY + "(" + Integer.toBinaryString(CAPACITY) + ")");
    System.out.println("RUNNING = \t" + RUNNING + "(" + Integer.toBinaryString(RUNNING) + ")");
    System.out.println("SHUTDOWN = \t" + SHUTDOWN + "(" + Integer.toBinaryString(SHUTDOWN) + ")");
    System.out.println("STOP = \t" + STOP + "(" + Integer.toBinaryString(STOP) + ")");
    System.out.println("TIDYING = \t" + TIDYING + "(" + Integer.toBinaryString(TIDYING) + ")");
    System.out.println("TERMINATED = \t" + TERMINATED + "(" + Integer.toBinaryString(TERMINATED) + ")");
    System.out.println(Integer.toBinaryString(~CAPACITY));
  }
}
