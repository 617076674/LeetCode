package question0372_super_pow;

/**
 * 数学题。
 *
 * 欧拉函数：对于一个正整数n，小于n且和n互质的正整数（包括1）的个数，记作φ(n) 。
 *
 * 欧拉函数的求法：
 * (1)φ(1)=1（唯一和1互质的数就是1本身）。
 * (2)φ(x) = x * (1 - 1 / p1) * (1 - 1 / p2) * ... * (1 - 1 / pn)，其中p1, p2, ..., pn为x的所有质因数，x是不为0的整数。
 *
 * 降幂公式：(A ^ B) % C = (A ^ (B % φ(C) + φ(C))) % C.
 *
 * 执行用时：1ms，击败100.00%。消耗内存：37.9MB，击败38.63%。
 */
public class Solution {
    public int superPow(int a, int[] b) {
        return quickPow(a, decreasePow(b, euler(1337)), 1337);
    }

    private int quickPow(long a, int sum, int remainder) {
        long result = 1;
        while (sum > 0) {
            if ((sum & 1) == 1) {
                result = result % remainder * a % remainder;
            }
            a = a % remainder * a % remainder;
            sum >>= 1;
        }
        return (int) result;
    }
    
    private int decreasePow(int[] b, int eulerNum) {
        int result = 0;
        for (int i = 0; i < b.length; i++) {
            result = (result * 10 + b[i]) % eulerNum;
        }
        result += eulerNum;
        return result;
    }

    private int euler(int x) {
        int result = x;
        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) {
                result = result - result / i;   //等价于通项，把x乘进去
                while (x % i == 0) {
                    x /= i; //确保下一个i是n的素因数
                }
            }
        }
        if (result > 1) {
            result = result - result / x;   //最后可能还剩下一个素因数没有除
        }
        return result;
    }
}