package top.lnj.leetcode.editor.cn;

/**
 * @author LiuNaiJie
 * on 2019-07-12
 */
public class T344 {

	public void reverseString(char[] s) {
		int time = s.length / 2;
		for (int i = 0; i < time; i++) {
			char temp = s[i];
			s[i] = s[s.length - 1 - i];
			s[s.length - 1 - i] = temp;
		}
	}

}
