/**
 * @author ：LiuNaiJie
 * @date ：2020-07-23
 */
public class T125 {

	public boolean is(String s) {
		char[] chars = s.toLowerCase().toCharArray();
		int left = 0, right = chars.length - 1;
		while (left < right) {
			while (!Character.isLetterOrDigit(chars[left]) && left < right) {
				left++;
			}
			while (!Character.isLetterOrDigit(chars[right]) && left < right) {
				right--;
			}
			if (chars[left] != chars[right]) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}

}
