package question0420_strong_password_checker;

public class Solution {

  public static void main(String[] args) {
    System.out.println(new Solution().strongPasswordChecker("aaaB1"));
  }

  public int strongPasswordChecker(String s) {
    //统计字符类型的缺失个数
    int[] missType = {1, 1, 1};
    //统计三种连续型子串的数量：长度模 3 为 0，1，2
    int[] mod3Cnt = new int[3];
    //统计修改次数
    int modifyCnt = 0;

    int len = s.length();

    for (int i = 0; i < len; ) {
      //统计字符类型
      char c = s.charAt(i);
      if (Character.isDigit(c)) {
        missType[0] = 0;
      } else if (Character.isLowerCase(c)) {
        missType[1] = 0;
      } else if (Character.isUpperCase(c)) {
        missType[2] = 0;
      }

      //统计连续子串（字符连续出现 3 次及以上）
      int iStart = i++;
      while (i < len && s.charAt(i) == c){
        i++;
      }
      int subLen = i - iStart;
      if (subLen >= 3) {
        //每3个替换1个，可保证不连续
        modifyCnt += subLen / 3;
        mod3Cnt[subLen % 3]++;
      }
    }

    int missTypeCnt = missType[0] + missType[1] + missType[2];

    //字符串长度限制为 [6，20]

    //1. 长度过短，仅考虑字符长度缺失和字符类型缺失
    if (len < 6) {
      return Math.max(6 - len, missTypeCnt);
    }
    //2. 长度合法，仅考虑连续字符串和字符类型缺失
    if (len <= 20) {
      return Math.max(modifyCnt, missTypeCnt);
    }
    //3. 长度过长，考虑删除过长的长度、连续字符串、字符类型缺失
    int deleteCnt = len - 20;

    //3n型子串，部分能通过删除转化成 3n + 2 型子串，每个子串删 1
    if (deleteCnt < mod3Cnt[0]) {
      return Math.max(modifyCnt - deleteCnt, missTypeCnt) + len - 20;
    }
    //3n 型子串，全部都能通过删除转化成 3n + 2 型子串
    deleteCnt -= mod3Cnt[0];
    modifyCnt -= mod3Cnt[0];

    //3n + 1 型子串，部分能通过删除转化成 3n + 2 型子串，每个子串删 2
    if (deleteCnt < mod3Cnt[1] * 2) {
      return Math.max(modifyCnt - deleteCnt / 2, missTypeCnt) + len - 20;
    }
    //3n + 1 型子串，全部都能通过删除转化成 3n + 2 型子串
    deleteCnt -= mod3Cnt[1] * 2;
    modifyCnt -= mod3Cnt[1];

    //3n + 2型子串
    // (1) 删除 len - 20 个字符，使字符串长度降到合法长度
    // (2) 根据合法长度的公式，应为 Math.max(modifyCnt, missTypeCnt);
    // (3) 由于删除时可以删除连续子串中的字符，减少 modifyCnt
    //    aaa aaa aa  原需替换 2 次
    //    aaa aaa a   删除 1 次，仍需替换 2 次
    //    aaa aaa     删除 2 次，仍需替换 2 次
    //    aaa aa      删除 3 次，仍需替换 1 次
    // 即对于 3n + 2 型子串，删除 3 次可抵消替换 1 次
    //其他型的子串可以转换成 3n + 2 型
    return Math.max(modifyCnt - deleteCnt / 3, missTypeCnt) + len - 20;
  }

}