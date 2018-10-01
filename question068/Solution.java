package question068;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/82847865
 */
import java.util.ArrayList;
import java.util.List;

public class Solution {

	public List<String> fullJustify(String[] words, int maxWidth) {
		List<String> list = new ArrayList<>();
		int n = words.length;
		if(n == 0) {
			return list;
		}
		//index represents which position in array words we are traversing now
		int index = 0;
		while(index < n) {
			//every String in list contains 1 word or more
			int len = words[index].length();
			int i = index + 1;
			for (; i < words.length; i++) {
				if(len + words[i].length() + 1 > maxWidth) {
					break;
				}
				len += words[i].length() + 1;
			}
			//levelLen represents how many characters that isn't space in erery String
			int levelLen = 0;
			for (int j = index; j < i; j++) {
				levelLen += words[j].length();
			}
			//numSpace represents how many space between 2 words
			int numSpace = i - index - 1;
			//string represents every String
			String string = "";
			if(i != words.length) {
				//if we haven't traversed all the words
				if(numSpace != 0) {
					//if this String has more than one word
					int[] spaces = new int[numSpace];
					int averageSpace = (maxWidth - levelLen) / numSpace;
					int remainSpace = maxWidth - levelLen - numSpace * averageSpace;
					for (int j = 0; j < numSpace; j++) {
						if(j + 1 <= remainSpace) {
							spaces[j] = 1 + averageSpace;
						}else {
							spaces[j] = averageSpace;
						}
					}
					for (int j = index, k = 0; j < i && k < numSpace;) {
						string += words[j];
						j++;
						for (int num = 0; num < spaces[k]; num++) {
							string += " ";
						}
						k++;
					}
				}
				string += words[i - 1];
				if(numSpace == 0) {
					//if this String only has one word, fill space in the remain position
					while(string.length() < maxWidth) {
						string += " ";
					}
				}
			}else {
				//if we have traversed all the words, the last String we need to put all words on the left 
				for (int j = index; j < i - 1; j++) {
					string += words[j] + " ";
				}
				string += words[i - 1];
				while(string.length() < maxWidth) {
					string += " ";
				}
			}
			list.add(string);
			index = i;
		}
		return list;
	}
}
