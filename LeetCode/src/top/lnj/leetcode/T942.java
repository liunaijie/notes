package top.lnj.leetcode; /**
 * @author LiuNaiJie
 * on 2019-05-27
 */

/**
 * 给定只含 "I"（增大）或 "D"（减小）的字符串 S ，令 N = S.length。
 * <p>
 * 返回 [0, 1, ..., N] 的任意排列 A 使得对于所有 i = 0, ..., N-1，都有：
 * <p>
 * 如果 S[i] == "I"，那么 A[i] < A[i+1]
 * 如果 S[i] == "D"，那么 A[i] > A[i+1]
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输出："IDID"
 * 输出：[0,4,1,3,2]
 * 示例 2：
 * <p>
 * 输出："III"
 * 输出：[0,1,2,3]
 * 示例 3：
 * <p>
 * 输出："DDI"
 * 输出：[3,2,0,1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= S.length <= 1000
 * S 只包含字符 "I" 或 "D"。
 */
public class T942 {

	public int[] diStringMatch(String S) {
		int length = S.length();
		int[] result = new int[length+1];
		char[] chars = S.toCharArray();
		int max = length;
		int min = 0;
		for (int i = 0; i < chars.length; i++) {
			char c = chars[i];
			switch (c) {
				case 'I':
					result[i] = min;
					min++;
					result[i + 1] = min;
					break;
				case 'D':
					result[i] = max;
					max--;
					result[i + 1] = max;
					break;
				default:
					break;
			}
		}
		return result;
	}

}
