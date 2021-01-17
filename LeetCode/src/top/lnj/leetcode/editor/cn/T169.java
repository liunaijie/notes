package top.lnj.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 多数元素
 * @author ：LiuNaiJie
 * @date ：2020-03-29
 */
public class T169 {

	/**
	 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
	 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
	 * 示例 1:
	 * 输入: [3,2,3]
	 * 输出: 3
	 * 示例 2:
	 * 输入: [2,2,1,1,1,2,2]
	 * 输出: 2
	 */

	public int majorityElement(int[] nums) {
		int n = nums.length;
		Map<Integer, Integer> map = new HashMap<>(n);
		for (int num : nums) {
			if (map.containsKey(num)) {
				int count = map.get(num);
				if ((count + 1) > n / 2) {
					return num;
				}
				map.put(num, count + 1);
			} else {
				map.put(num, 1);
			}
		}
		return nums[0];
	}

	/**
	 * 排序后 在n/2位的肯定是多数元素
	 * @param nums
	 * @return
	 */
	public int majorityElementSort(int[] nums) {
		Arrays.sort(nums);
		return nums[nums.length / 2];
	}

}
