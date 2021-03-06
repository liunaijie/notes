package top.lnj.leetcode.editor.cn; /**
 * @author LiuNaiJie
 * on 2019-08-05
 */

/**
 * 实现 strStr()
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * 示例 1:
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 */
public class T28 {


	/**
	 * 这个题目相当于要求自己实现一个indexof()方法，所以没有直接调用indexof()方法。
	 *
	 * @param haystack
	 * @param needle
	 * @return
	 */
	public int strStr(String haystack, String needle) {
		if (needle.length() == 0) {
			return 0;
		}
		int strLength = haystack.length();
		int wordLength = needle.length();
		if (strLength < wordLength) {
			return -1;
		}
		for (int i = 0; i < strLength; i++) {
			if (i + wordLength > strLength) {
				// 当后面的字符串比要求校验的参数还短的时候就直接退出。
				break;
			}
			// 每次寻找相同位数的字符串
			String temp = haystack.substring(i, i + wordLength);
			if (needle.equals(temp)) {
				return i;
			}
		}
		return -1;
	}

}
