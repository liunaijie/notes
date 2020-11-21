package top.lnj.leetcode;

/**
 * 最长公共前缀
 *
 * @author ：LiuNaiJie
 * @date ：2020-03-14
 */
public class T14 {

	/**
	 * 如果不存在公共前缀，返回空字符串 ""。
	 * 示例 1:
	 * 输入: ["flower","flow","flight"]
	 * 输出: "fl"
	 * 示例 2:
	 * 输入: ["dog","racecar","car"]
	 * 输出: ""
	 * 解释: 输入不存在公共前缀。
	 * 说明:
	 * 所有输入只包含小写字母 a-z 。
	 */
	public static String longestCommonPrefix(String[] strs) {
		if (strs.length == 0) {
			return "";
		} else if (strs.length == 1) {
			return strs[0];
		}
		String result = strs[0];
		for (int i = 1; i < strs.length; i++) {
			int end = 0;
			for (; end < result.length() && end < strs[i].length(); end++) {
				if (result.charAt(end) != strs[i].charAt(end)) {
					break;
				}
			}
			result = result.substring(0, end);
			if ("".equals(result)) {
				return result;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		String[] s = {"flower", "flow", "flight"};
		System.out.println(longestCommonPrefix(s));
	}

}
