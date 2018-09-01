package question013;

/*
 * ½âÎöÇë¼û£ºhttps://blog.csdn.net/qq_41231926/article/details/82141791
 */
public class Solution {
	
	public int romanToInt(String s) {
		int result = 0;
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length; i++) {
			if(array[i] == 'I') {
				if(i + 1 < array.length && array[i + 1] == 'V') {
					result += 4;
					i++;
				}else if(i + 1 < array.length && array[i + 1] == 'X') {
					result += 9;
					i++;
				}else {
					result += 1;
				}
			}else if(array[i] == 'V') {
				result += 5;
			}else if(array[i] == 'X') {
				if(i + 1 < array.length && array[i + 1] == 'L') {
					result += 40;
					i++;
				}else if(i + 1 < array.length && array[i + 1] == 'C') {
					result += 90;
					i++;
				}else {
					result += 10;
				}
			}else if(array[i] == 'L') {
				result += 50;
			}else if(array[i] == 'C') {
				if(i + 1 < array.length && array[i + 1] == 'D') {
					result += 400;
					i++;
				}else if(i + 1 < array.length && array[i + 1] == 'M') {
					result += 900;
					i++;
				}else {
					result += 100;
				}
			}else if(array[i] == 'D') {
				result += 500;
			}else if(array[i] == 'M') {
				result += 1000;
			}
		}
        return result;
    }
	
	public static void main(String[] args) {
		System.out.println(new Solution().romanToInt("I"));
	}
}
