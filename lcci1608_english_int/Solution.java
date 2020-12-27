package lcci1608_english_int;

public class Solution {

    private String[] singleBitNum2String = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten"};

    private String[] tenAndTwenty = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

    private String[] twoBitNum2String = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        return number2String(num);
    }

    private String number2String(int num) {
        if (num == 0) {
            return "";
        }
        if (num < 10) {
            return singleBitNum2String[num];
        }
        if (num < 100) {
            if (num % 10 == 0) {
                return twoBitNum2String[num / 10];
            }
            if (num < 20) {
                return tenAndTwenty[num - 10];
            }
            return twoBitNum2String[num / 10] + " " + singleBitNum2String[num % 10];
        }
        if (num < 1000) {
            if (num % 100 == 0) {
                return singleBitNum2String[num / 100] + " " + "Hundred";
            }
            return singleBitNum2String[num / 100] + " " + "Hundred" + " " + number2String(num % 100);
        }
        if (num < 1000000) {
            if (num % 1000 == 0) {
                return number2String(num / 1000) + " " + "Thousand";
            }
            return number2String(num / 1000) + " " + "Thousand" + " " + number2String(num % 1000);
        }
        if (num < 1000000000) {
            if (num % 1000000 == 0) {
                return number2String(num / 1000000) + " " + "Million";
            }
            return number2String(num / 1000000) + " " + "Million" + " " + number2String(num % 1000000);
        }
        if (num % 1000000000 == 0) {
            return number2String(num / 1000000000) + " " + "Billion";
        }
        return number2String(num / 1000000000) + " " + "Billion" + " " + number2String(num % 1000000000);
    }

}