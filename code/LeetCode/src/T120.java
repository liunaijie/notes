import java.util.List;

/**
 * @author LiuNaiJie
 * on 2019-06-22
 */

/**
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * 例如，给定三角形：
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * 说明：
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分
 * <p>
 * 这个题目中题意说明了，每一步只能移动到下一行中相邻的节点
 * 那就是(m,n)下一步只能走(m+1,n),(m+1,n+1)两条路线
 */
public class T120 {

	/**
	 * 从上往下计算，利用二维数组
	 * <p>
	 * m行n列时，首先取m-1行中n与n-1两个值的最小值，然后加上自身，这就是最小路径
	 * 如果是第一行那这个数就是本身
	 * 如果在这一行是第一个数，他的路径肯定是全部第一个数，所以就取本身与上一行第一个数相加
	 * 如果在这一行是最后一个数，他的路径是全部最后一个数，就取本身与上一行最后一个数相加
	 *
	 * @param triangle
	 * @return
	 */
	public static int minimumTotalTwo(List<List<Integer>> triangle) {
		if (triangle.size() == 0) {
			return 0;
		}
		int[][] paths = new int[triangle.size()][triangle.size()];
		for (int i = 0; i < triangle.size(); i++) {
			List<Integer> single = triangle.get(i);
			if (single.size() == 1) {
				// 该行只有一个数据 即为第一行
				paths[i][0] = single.get(0);
				continue;
			}
			for (int j = 0; j < single.size(); j++) {
				if (j == 0) {
					// 当前行第一个数字 是上一行的和与当前值 由于是第一个所以不存在两个之间最小值 下面的最后一个数字同理
					paths[i][j] = paths[i - 1][0] + single.get(0);
				} else if (j == single.size() - 1) {
					// 当前行最后一个数字
					paths[i][j] = paths[i - 1][j - 1] + single.get(j);
				} else {
					paths[i][j] = Math.min(paths[i - 1][j - 1], paths[i - 1][j]) + single.get(j);
				}
			}
		}
		int[] nums = paths[triangle.size() - 1];
		int min = nums[0];
		for (int temp : nums) {
			if (temp < min) {
				min = temp;
			}
		}
		return min;
	}

	/**
	 * 从下往上计算，利用一维数组
	 * 每一列n获取上一行中n与n+1的最小值，然后再加上自身，作为当前行的n值
	 * 由于第一行只有一个数值，所以最终取dp[o]即为最终的计算结果
	 *
	 * @param triangle
	 * @return
	 */
	public static int minimumTotal(List<List<Integer>> triangle) {
		if (triangle.size() == 0) {
			return 0;
		}
		int[] dp = new int[triangle.size() + 1];
		// 从后向前进行计算
		for (int i = triangle.size() - 1; i >= 0; i--) {
			List<Integer> content = triangle.get(i);
			for (int j = 0; j < content.size(); j++) {
				dp[j] = Math.min(dp[j], dp[j + 1]) + content.get(j);
			}
		}
		return dp[0];
	}

}
