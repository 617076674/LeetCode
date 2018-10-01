package question065;

import java.util.HashSet;
import java.util.Set;

public class Solution {

	public boolean isNumber(String s) {
		//remove the space on the border
		int left = 0;
		while(s.charAt(left) == ' ') {
			left++;
			//if s only contains ' ', return false
			if(left == s.length()) {
				return false;
			}
		}
		int right = s.length() - 1;
		while(s.charAt(right) == ' ') {
			right--;
		}
		s = s.substring(left, right + 1);
		if(s.charAt(0) == '-' || s.charAt(0) == '+') {
			s = s.substring(1);
		}

		Set<Character> validCharacter = new HashSet<>();
		validCharacter.add('.');
		validCharacter.add('e');
		validCharacter.add('E');
		for (int i = 0; i <= 9; i++) {
			validCharacter.add((char) ('0' + i));
		}
		int countPoint = 0;
		int countE = 0;
		int indexPoint = -1;
		int indexE = -1;
		for (int i = 0; i < s.length(); i++) {
			//if s contains character except '.', 'e', '0' ~ '9', return false
			if(!validCharacter.contains(s.charAt(i))) {
				return false;
			}
			if(s.charAt(i) == '.') {
				indexPoint = i;
				countPoint++;
				//if s contains 2 or more '.', return false
				if(countPoint >= 2) {
					return false;
				}
			}
			if(s.charAt(i) == 'e' || s.charAt(i) == 'E') {
				indexE = i;
				if(indexE < s.length() - 1) {
					if(s.charAt(indexE + 1) == '-' || s.charAt(indexE + 1) == '+') {
						if(indexE + 1 == s.length() - 1) {
							return false;
						}
						i++;
					}
				}
				//if s contains 2 or more 'e' and 'E', return false
				countE++;
				if(countE >= 2) {
					return false;
				}
			}
		}
		if(indexPoint == 0) {
			//if s contains '.' and s.length() == 1, return false
			if(s.length() == 1) {
				return false;
			}
			//if '.' is followed by 'e' or 'E', return false
			if(indexPoint + 1 == indexE) {
				return false;
			}
		}
		//if 'e' or 'E' in the first or last character of s, return false
		if(indexE == 0 || indexE == s.length() - 1) {
			return false;
		}
		//if index of '.' is greater than index of 'e' or 'E', return false
		if(indexPoint != -1 && indexE != -1) {
			if(indexPoint > indexE) {
				return false;
			}
		}
		return true;
	}
}
