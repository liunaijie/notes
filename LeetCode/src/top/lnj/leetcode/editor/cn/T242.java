package top.lnj.leetcode.editor.cn;

import java.util.Arrays;

/**
 * 有效的字母异位词
 *
 * @author ：NaiJie Liu
 * @date ：2020/11/22
 */

public class T242 {

	/**
	 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
	 * 示例 1:
	 * 输入: s = "anagram", t = "nagaram"
	 * 输出: true
	 * 示例 2:
	 * 输入: s = "rat", t = "car"
	 * 输出: false
	 * 说明:
	 * 你可以假设字符串只包含小写字母。
	 * 进阶:
	 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
	 */
	public boolean isAnagram(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		char[] sChars = s.toCharArray();
		char[] tChars = t.toCharArray();
		Arrays.sort(sChars);
		Arrays.sort(tChars);
		return Arrays.equals(sChars, tChars);
	}

	public boolean isAnagramHash(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		int[] map = new int[26];
		for (int i = 0; i < s.length(); i++) {
			map[s.charAt(i) - 'a']++;
		}
		for (int i = 0; i < t.length(); i++) {
			map[t.charAt(i) - 'a']--;
			if (map[t.charAt(i) - 'a']-- < 0) {
				return false;
			}
		}
		return true;
	}



}
