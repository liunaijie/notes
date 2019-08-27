/**
 * @author LiuNaiJie
 * on 2019-06-22
 */

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 示例:
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 */
public class T17 {

	/**
	 * 当我们输入第一个字符时，所有的组合是这个字符对应的几个字母（这个字符对应了m个字母，现在的组合有m种）
	 * 当我们再输入一个字符时，所有的组合变成了 我们刚刚的几种可能与我们现在输入的这个字符相乘（这个字符对应了n个字母，那就是m*n种可能）
	 * 再输入一个字符（对应z种字母）时，组合就有m*n*z种可能性
	 *
	 * @param digits
	 * @return
	 */
	public List<String> letterCombinations(String digits) {
		char[] chars = digits.toCharArray();
		Map<String, List<String>> keys = new HashMap<String, List<String>>();
		keys.put("2", Arrays.asList("a", "b", "c"));
		keys.put("3", Arrays.asList("d", "e", "f"));
		keys.put("4", Arrays.asList("g", "h", "i"));
		keys.put("5", Arrays.asList("j", "k", "l"));
		keys.put("6", Arrays.asList("m", "n", "o"));
		keys.put("7", Arrays.asList("p", "q", "r", "s"));
		keys.put("8", Arrays.asList("t", "u", "v"));
		keys.put("9", Arrays.asList("w", "x", "y", "z"));
		List<String> result = new ArrayList<String>();
		for (char c : chars) {
			// 拿到输入的字符对应的字母
			List values = keys.get(String.valueOf(c));
			result = add(result, values);
		}
		return result;
	}

	/**
	 * @param old 已经有的组合
	 * @param now 又要添加的字符
	 * @return
	 */
	private List<String> add(List<String> old, List<String> now) {
		if (old == null || old.size() == 0) {
			// 如果之前没有组合，那新的字母就是所有的组合
			old = now;
			return old;
		}
		List<String> result = new ArrayList<String>();
		for (String oldWord : old) {
			for (String newWord : now) {
				result.add(oldWord + newWord);
			}
		}
		return result;
	}

}
