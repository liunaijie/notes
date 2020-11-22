package top.lnj.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

/**
 * 无重复字符的最长子串
 *
 * @author ：LiuNaiJie
 * @date ：2020-03-14
 */
public class T3 {


	public int lengthOfLongestSubstring(String s) {
		int length = 0;
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			int index = str.indexOf(String.valueOf(s.charAt(i)));
			if (index < 0) {
				str.append(s.charAt(i));
			} else {
				String rest = str.substring(index + 1);
				str.setLength(0);
				str.append(rest);
				str.append(s.charAt(i));
			}
			length = Math.max(length, str.length());
		}
		return length;
	}

	public int lengthOfLongestSubstringWindow(String s) {
		int n = s.length();
		Set<Character> set = new HashSet<>();
		int result = 0, i = 0, j = 0;
		while (i < n && j < n) {
			if (!set.contains(s.charAt(j))) {
				set.add(s.charAt(j++));
				result = Math.max(result, j - i);
			} else {
				//一直向右删除，一直到不再包含此字符
				set.remove(s.charAt(i++));
			}
		}
		return result;
	}

	public String lengthOfLongestSubstringWindowString(String s) {
		int n = s.length();
		Set<Character> set = new HashSet<>();
		int result = 0, i = 0, j = 0;
		String word = "";
		StringBuilder stringBuilder = new StringBuilder();
		while (i < n && j < n) {
			if (!set.contains(s.charAt(j))) {
				stringBuilder.append(s.charAt(j));
				set.add(s.charAt(j++));
				result = Math.max(result, j - i);
			} else {
				//一直向右删除，一直到不再包含此字符
				set.remove(s.charAt(i++));
				stringBuilder.setLength(0);
			}
			if (stringBuilder.length() > word.length()) {
				word = stringBuilder.toString();
			}
		}
		return word;
	}


}
