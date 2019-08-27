/**
 * 1021. 删除最外层的括号
 *
 * @author LiuNaiJie
 * on 2019-05-21
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 有效括号字符串为空 ("")、"(" + A + ")" 或 A + B，其中 A 和 B 都是有效的括号字符串，+ 代表字符串的连接。
 * 例如，""，"()"，"(())()" 和 "(()(()))" 都是有效的括号字符串。
 * <p>
 * 如果有效字符串 S 非空，且不存在将其拆分为 S = A+B 的方法，我们称其为原语（primitive），其中 A 和 B 都是非空有效括号字符串。
 * <p>
 * 给出一个非空有效字符串 S，考虑将其进行原语化分解，使得：S = P_1 + P_2 + ... + P_k，其中 P_i 是有效括号字符串原语。
 * <p>
 * 对 S 进行原语化分解，删除分解中每个原语字符串的最外层括号，返回 S 。
 * <p>
 * 示例 1：
 * <p>
 * 输入："(()())(())"
 * 输出："()()()"
 * 解释：
 * 输入字符串为 "(()())(())"，原语化分解得到 "(()())" + "(())"，
 * 删除每个部分中的最外层括号后得到 "()()" + "()" = "()()()"。
 * 示例 2：
 * <p>
 * 输入："(()())(())(()(()))"
 * 输出："()()()()(())"
 * 解释：
 * 输入字符串为 "(()())(())(()(()))"，原语化分解得到 "(()())" + "(())" + "(()(()))"，
 * 删除每隔部分中的最外层括号后得到 "()()" + "()" + "()(())" = "()()()()(())"。
 * 示例 3：
 * <p>
 * 输入："()()"
 * 输出：""
 * 解释：
 * 输入字符串为 "()()"，原语化分解得到 "()" + "()"，
 * 删除每个部分中的最外层括号后得到 "" + "" = ""。
 * <p>
 * <p>
 * 提示：
 * <p>
 * S.length <= 10000
 * S[i] 为 "(" 或 ")"
 * S 是一个有效括号字符串
 */
public class T1021 {

	/**
	 * 先进行第一步分解，得到每个原语字符串
	 * 对每一个原语字符串去掉最外层括号，既第一个与最后一个字符
	 *
	 * @param S
	 * @return
	 */
	public String removeOuterParentheses(String S) {
		int left = 0;
		List<String> list = new ArrayList<String>();
		StringBuilder item = new StringBuilder();
		for (int i = 0; i < S.length(); i++) {
			char c = S.charAt(i);
			if (c == '(') {
				item.append(c);
				left += 1;
			} else if (c == ')') {
				item.append(c);
				left -= 1;
			}
			if (left == 0 && item.length() % 2 == 0) {
				list.add(item.toString());
				item.setLength(0);
			}
		}
		StringBuilder result = new StringBuilder();
		for (String temp : list) {
			temp = temp.substring(1, temp.length() - 1);
			result.append(temp);
		}
		return result.toString();
	}

}
