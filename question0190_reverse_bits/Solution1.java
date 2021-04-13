package question0190_reverse_bits;

public class Solution1 {

  private static final int M1 = 0x55555555; // 01010101 01010101 01010101 01010101

  private static final int M2 = 0x33333333; // 00110011 00110011 00110011 00110011

  private static final int M4 = 0x0f0f0f0f; // 00001111 00001111 00001111 00001111

  private static final int M8 = 0x00ff00ff; // 00000000 11111111 00000000 11111111

  private static final int M16 = 0xffffffff; // 11111111 11111111 11111111 11111111

  public int reverseBits(int n) {
    n = (n >>> 16) & M16 | (n & M16) << 16;
    n = (n >>> 8) & M8 | (n & M8) << 8;
    n = (n >>> 4) & M4 | (n & M4) << 4;
    n = (n >>> 2) & M2 | (n & M2) << 2;
    n = (n >>> 1) & M1 | (n & M1) << 1;
    return n;
  }

}