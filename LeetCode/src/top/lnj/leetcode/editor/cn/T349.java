package top.lnj.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

/**
 * @author LiuNaiJie
 * on 2019-08-23
 * 两个数组的交集
 */
public class T349 {


	public int[] intersection(int[] nums1, int[] nums2) {
		Set<Integer> set1 = new HashSet<Integer>();
		for (int item : nums1) {
			set1.add(item);
		}
		Set<Integer> set2 = new HashSet<Integer>();
		for (int item : nums2) {
			if (set1.contains(item)) {
				set2.add(item);
			}
		}
		int[] result = new int[set2.size()];
		int index = 0;
		for (Integer integer : set2) {
			result[index++] = integer;
		}
		return result;
	}

}
