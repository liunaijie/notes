package top.lnj.leetcode;

import java.util.*;

/**
 * 三数之和
 *
 * @author ：LiuNaiJie
 * @date ：2020-03-13
 */
public class T15 {

	/**
	 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
	 *
	 * 注意：答案中不可以包含重复的三元组。
	 *
	 *  
	 *
	 * 示例：
	 *
	 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
	 *
	 * 满足要求的三元组集合为：
	 * [
	 *   [-1, 0, 1],
	 *   [-1, -1, 2]
	 * ]
	 * */


	/**
	 * 暴力解法
	 *
	 * @param nums
	 * @return
	 */
	public List<List<Integer>> threeSumForce(int[] nums) {
		if (nums == null || nums.length <= 2) {
			return Collections.emptyList();
		}
		Set<List<Integer>> result = new LinkedHashSet<>();
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				for (int k = j + 1; k < nums.length; k++) {
					if (nums[i] + nums[j] + nums[k] == 0) {
						List<Integer> value = Arrays.asList(nums[i], nums[j], nums[k]);
						value.sort(Comparator.naturalOrder());
						result.add(value);
					}
				}
			}
		}
		return new ArrayList<>(result);
	}

	/**
	 * 哈希表
	 *
	 * @param nums
	 * @return
	 */
	public List<List<Integer>> threeSumHash(int[] nums) {
		if (nums == null || nums.length <= 2) {
			return Collections.emptyList();
		}
		Set<List<Integer>> result = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			int target = -nums[i];
			Map<Integer, Integer> map = new HashMap<>();
			for (int j = i + 1; j < nums.length; j++) {
				int y = target - nums[j];
				if (map.containsKey(y)) {
					List<Integer> list = Arrays.asList(nums[i], nums[j], y);
					list.sort(Comparator.naturalOrder());
					result.add(list);
				} else {
					map.put(nums[j], j);
				}
			}
		}
		return new ArrayList<>(result);
	}

	public List<List<Integer>> threeSumDouble(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<>();
		for (int k = 0; k < nums.length; k++) {
			if (nums[k] > 0) {
				break;
			}
			if (k > 0 && nums[k] == nums[k - 1]) {
				continue;
			}
			int i = k + 1, j = nums.length - 1;
			while (i < j) {
				int sum = nums[k] + nums[i] + nums[j];
				if (sum < 0) {
					while (i < j && nums[i] == nums[++i]) ;
				} else if (sum > 0) {
					while (i < j && nums[j] == nums[--j]) ;
				} else {
					result.add(new ArrayList<>(Arrays.asList(nums[k], nums[i], nums[j])));
					while (i < j && nums[i] == nums[++i]) ;
					while (i < j && nums[j] == nums[--j]) ;
				}
			}
		}
		return result;
	}


}
