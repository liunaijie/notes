package top.lnj.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiuNaiJie
 * on 2019-07-12
 */
public class T500 {

	public String[] findWords(String[] words) {
		String[] lines = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
		List<String> result = new ArrayList<>();
		for (String word : words) {
			char[] chars = word.toLowerCase().toCharArray();
			for (String line : lines) {
				if (line.contains(String.valueOf(chars[0]))) {
					boolean check = checkWord(line, chars);
					if (check) {
						result.add(word);
					}
				}
			}
		}
		return result.toArray(new String[result.size()]);
	}


	public static boolean checkWord(String line, char[] chars) {
		boolean flag = true;
		for (char c : chars) {
			if (!line.contains(String.valueOf(c))) {
				flag = false;
			}
		}
		return flag;
	}

}
