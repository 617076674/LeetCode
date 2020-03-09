package question0751_ip_to_cidr;

import java.util.ArrayList;
import java.util.List;

/**
 * 贪心算法。
 *
 * 对于某个地址ip，寻找其最右边的1的位置。
 *
 * 假设最右边1的位置的索引（从右往左）是k，那么这个长度为(32 - k)的ip地址能够代表(1 << k)个地址，因为最右边的1后面的0可以随意变换。
 *
 * 执行用时：12ms，击败48.57%。消耗内存：39.8MB，击败9.09%。
 */
public class Solution {
    public List<String> ipToCIDR(String ip, int n) {
        List<String> result = new ArrayList<>();
        long num = ipToLong(ip);
        int k = 0;
        while ((num & (1 << k)) == 0) {
            k++;
        }
        long count = (1 << k);
        if (n == count) {
            result.add(longToIp(num) + "/" + (32 - k));
            return result;
        } else if (n > count) {
            result.add(longToIp(num) + "/" + (32 - k));
            result.addAll(ipToCIDR(longToIp(num + count), n - (int) count));
            return result;
        }
        while ((1 << k) > n) {
            k--;
        }
        result.add(longToIp(num) + "/" + (32 - k));
        int remain = n - (1 << k);
        if (remain > 0) {
            result.addAll(ipToCIDR(longToIp(num + (1 << k)), remain));
        }
        return result;
    }

    private long ipToLong(String ip) {
        String[] strings = ip.split("\\.");
        long result = 0;
        for (int i = 0; i <= 3; i++) {
            result = result * 256 + Integer.parseInt(strings[i]);
        }
        return result;
    }

    private String longToIp(long num) {
        StringBuilder sb = new StringBuilder();
        sb.append(num % 256);
        for (int i = 0; i < 3; i++) {
            num /= 256;
            sb.insert(0, ".");
            sb.insert(0, num % 256);
        }
        return sb.toString();
    }
}