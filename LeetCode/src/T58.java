/**
 * 最后一个单词的长度
 *
 * @author ：LiuNaiJie
 * @date ：2020-03-14
 */
public class T58 {

	/**
	 * 给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
	 * <p>
	 * 如果不存在最后一个单词，请返回 0 。
	 * <p>
	 * 说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。
	 * <p>
	 *  
	 * <p>
	 * 示例:
	 * <p>
	 * 输入: "Hello World"
	 * 输出: 5
	 */
	public int lengthOfLastWord(String s) {
		int index = s.length() - 1;
		//先将字符串后面的空格去掉
		while (index >= 0 && s.charAt(index) == ' ') {
			index--;
		}
		//如果不存在最后一个单词，返回0
		if (index < 0) {
			return 0;
		}
		//查找最后一个单词
		int start = index;
		while (start >= 0 && s.charAt(start) != ' ') {
			start--;
		}
		//返回长度
		return index - start;
	}


}
