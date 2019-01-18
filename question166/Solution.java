package question166;

import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        return fractionToDecimal((long)numerator, (long)denominator);
    }
    public String fractionToDecimal(long numerator, long denominator) {
        StringBuilder stringBuilder = new StringBuilder();
        boolean flag = true;
        if(numerator < 0){
            flag = !flag;
            numerator *= -1;
        }
        if(denominator < 0){
            flag = !flag;
            numerator *= -1;
        }
        if(!flag && 0 != numerator){
            stringBuilder.append("-");
        }
        long integer = numerator / denominator;
        stringBuilder.append(integer);
        if(0 == numerator % denominator){
            return stringBuilder.toString();
        }
        stringBuilder.append(".");
        StringBuilder decimal = new StringBuilder();
        numerator -= integer * denominator;
        HashMap<Long, Long> hashMap = new HashMap<>();    //键代表的是被除数，值代表的是余数
        HashSet<Long> hashSet = new HashSet<>(); //存储重复的被除数
        StringBuilder loop = new StringBuilder();
        while(0 != numerator){
            decimal.append(numerator * 10 / denominator);
            hashMap.put(numerator, numerator * 10 % denominator);
            numerator = hashMap.get(numerator);
            if(hashMap.containsKey(numerator)){
                if(hashSet.contains(numerator)){
                    break;
                }else{
                    loop.append(numerator * 10 / denominator);
                    hashSet.add(numerator);
                }

            }
        }
        if(0 != numerator){
            return stringBuilder.toString() + decimal.substring(0, decimal.indexOf(loop.toString())) + "(" + loop + ")";
        }else{
            return stringBuilder.append(decimal).toString();
        }
    }
}
