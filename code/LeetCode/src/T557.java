/**
 * @author LiuNaiJie
 * on 2019-07-12
 */
public class T557 {

	public String reverseWords(String s) {
		String[] words = s.split(" ");
		StringBuilder stringBuilder = new StringBuilder();
		for (String word : words) {
			char[] chars = word.toCharArray();
			for (int i = chars.length - 1; i >= 0; i--) {
				stringBuilder.append(chars[i]);
			}
			stringBuilder.append(" ");
		}
		return stringBuilder.toString().substring(0, stringBuilder.length() - 1);
	}

	/**
	 * 将字符串转换为字符数组，
	 * 从0开始寻找空格，即单词分隔
	 * 将这个单词的顺序进行翻转
	 * 然后从刚才处理的位置后再寻找下一个空格，重复
	 *
	 * @param s
	 * @return
	 */
	public String reverseWord(String s) {
		char[] chars = s.toCharArray();
		int start = 0;
		while (start < s.length()) {
			int end = s.indexOf(" ", start + 1);
			if (end == -1) {
				end = s.length();
			}
			//将每个单词的顺序进行转换
			chars = reverseWord(start, end, chars);
			start = end + 1;

		}
		return String.valueOf(chars);
	}

	public static char[] reverseWord(int start, int end, char[] chars) {
		for (int i = start, j = end - 1; i < j; i++, j--) {
			char c = chars[i];
			chars[i] = chars[j];
			chars[j] = c;
		}
		return chars;
	}


}
