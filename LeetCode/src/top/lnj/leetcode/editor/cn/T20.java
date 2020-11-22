package top.lnj.leetcode.editor.cn; /**
 * @author LiuNaiJie
 * on 2019-08-05
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 * 输入: "{[]}"
 * 输出: true
 */
public class T20 {

	/**
	 * 判断是不是有效的括号
	 * 判断结束括号，当遇到结束括号时，判断上一个字符是不是这个括号对应的开始括号
	 * 当不是结束括号时，在栈中添加这个开始括号
	 *
	 * @param s
	 * @return
	 */
	public boolean isValid(String s) {
		if (s.length() % 2 != 0) {
			// 如果不是偶数长度直接返回
			return false;
		}
		Stack<Character> stack = new Stack<Character>();
		Map<Character, Character> map = new HashMap<Character, Character>();
		map.put(')', '(');
		map.put(']', '[');
		map.put('}', '{');
		char[] chars = s.toCharArray();
		for (char c : chars) {
			if (map.containsKey(c)) {
				if (stack.isEmpty()) {
					return false;
				}
				char temp = stack.pop();
				if (temp != map.get(c)) {
					return false;
				}
			} else {
				stack.add(c);
			}
		}
		return stack.isEmpty();
	}

}
