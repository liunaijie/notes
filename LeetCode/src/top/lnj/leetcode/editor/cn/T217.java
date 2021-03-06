package top.lnj.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 存在重复元素
 *
 * @author ：LiuNaiJie
 * @date ：2020-03-12
 */
public class T217 {

	/**
	 * 给定一个整数数组，判断是否存在重复元素。
	 * <p>
	 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
	 * <p>
	 * 示例 1:
	 * <p>
	 * 输入: [1,2,3,1]
	 * 输出: true
	 * 示例 2:
	 * <p>
	 * 输入: [1,2,3,4]
	 * 输出: false
	 * 示例 3:
	 * <p>
	 * 输入: [1,1,1,3,3,4,3,2,4,2]
	 * 输出: true
	 */

	public boolean containsDuplicateFor(int[] nums) {
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] == nums[j]) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean containsDuplicateSort(int[] nums) {
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] == nums[i + 1]) {
				return true;
			}
		}
		return false;
	}

	public boolean containsDuplicateHash(int[] nums) {
		Set<Integer> set = new HashSet<>(nums.length);
		for (int num : nums) {
			if (set.contains(num)) {
				return true;
			} else {
				set.add(num);
			}
		}
		return false;
	}


}
