/**
 * @author ：LiuNaiJie
 * @date ：2020-04-07
 */
public class T34 {

	public int[] searchRange(int[] nums, int target) {
		int first = -1;
		int last = -1;
		if (nums == null || nums.length ==0) {
			return new int[]{first, last};
		}
		first = searchRangeHelp(nums, target, true);
		last = searchRangeHelp(nums, target, false);
		return new int[]{first, last};
	}


	private int searchRangeHelp(int[] nums, int target, boolean firstOrLast) {
		int left = 0, right = nums.length - 1;
		while (left <= right) {
			int firstMid = left + (right - left) / 2;
			int lastMid = left + (right - left) / 2;
			if (nums[firstMid] < target) {
				left = firstMid + 1;
			} else if (nums[firstMid] > target) {
				right = firstMid - 1;
			} else {
				if (firstOrLast) {
					if (firstMid == 0 || nums[firstMid - 1] != target) {
						return firstMid;
					} else {
						right = firstMid - 1;
					}
				} else {
					if (lastMid == nums.length - 1 || nums[lastMid + 1] != target) {
						return lastMid;
					} else {
						left = lastMid + 1;
					}
				}

			}
		}
		return -1;
	}

}
