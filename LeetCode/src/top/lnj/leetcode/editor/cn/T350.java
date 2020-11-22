package top.lnj.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author LiuNaiJie
 * on 2019-08-23
 */
public class T350 {

	public int[] intersect(int[] nums1, int[] nums2) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int item : nums2) {
			if (map.containsKey(item)) {
				map.put(item, map.get(item) + 1);
			} else {
				map.put(item, 1);
			}
		}
		List<Integer> list = new ArrayList<Integer>();
		for (int item : nums1) {
			if (map.containsKey(item) && map.get(item) > 0) {
				list.add(item);
				map.put(item, map.get(item) - 1);
			}
		}
		int[] result = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			result[i] = list.get(i);
		}
		return result;
	}

}
