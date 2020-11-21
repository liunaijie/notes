package top.lnj.leetcode; /**
 * @author LiuNaiJie
 * on 2019-06-25
 */

/**
 * 保持城市天际线
 * 在二维数组grid中，grid[i][j]代表位于某处的建筑物的高度。 我们被允许增加任何数量（不同建筑物的数量可能不同）的建筑物的高度。 高度 0 也被认为是建筑物。
 * 最后，从新数组的所有四个方向（即顶部，底部，左侧和右侧）观看的“天际线”必须与原始数组的天际线相同。 城市的天际线是从远处观看时，由所有建筑物形成的矩形的外部轮廓。 请看下面的例子。
 * 建筑物高度可以增加的最大总和是多少？
 * 例子：
 * 输入： grid = [[3,0,8,4],[2,4,5,7],[9,2,6,3],[0,3,1,0]]
 * 输出： 35
 * 解释：
 * The grid is:[
 * [3, 0, 8, 4],
 * [2, 4, 5, 7],
 * [9, 2, 6, 3],
 * [0, 3, 1, 0] ]
 * <p>
 * 从数组竖直方向（即顶部，底部）看“天际线”是：[9, 4, 8, 7]
 * 从水平水平方向（即左侧，右侧）看“天际线”是：[8, 7, 9, 3]
 * <p>
 * 在不影响天际线的情况下对建筑物进行增高后，新数组如下：
 * <p>
 * gridNew = [
 * [8, 4, 8, 7],
 * [7, 4, 7, 7],
 * [9, 4, 8, 7],
 * [3, 3, 3, 3] ]
 * 说明:
 * 1 < grid.length = grid[0].length <= 50。
 *  grid[i][j] 的高度范围是： [0, 100]。
 * 一座建筑物占据一个grid[i][j]：换言之，它们是 1 x 1 x grid[i][j] 的长方体。
 */
public class T807 {


	/**
	 * 给定数组 grid得到行数i，列数j
	 * 获取侧面查看的最大值：定义一个长度为i的数组left
	 * 计算第i行的最大值，将该值放到left[i]的位置
	 * 获取地面查看的最大值：定义一个长度为j的数组top
	 * 计算第j列的最大值，然后将该值放到top[j]的位置
	 * 然后再计算(i,j)点能达到的最大值，就是 top[j]与left[i]的最小值
	 * 求可以增加的最大总和，将每个位置上两者的最小值进行累加再减去对应位置上原有的值
	 *
	 * @param grid
	 * @return
	 */
	public static int maxIncreaseKeepingSkyline(int[][] grid) {
		int[] left = new int[grid.length];
		int[] top = new int[grid[0].length];

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				left[i] = Math.max(grid[i][j], left[i]);
				top[j] = Math.max(grid[i][j], top[j]);
			}
		}
		int result = 0;
		for (int i = 0; i < left.length; i++) {
			for (int j = 0; j < top.length; j++) {
				result += Math.min(left[i], top[j]) - grid[i][j];
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[][] grid = {{3, 0, 8, 4}, {2, 4, 5, 7}, {9, 2, 6, 3}, {0, 3, 1, 0}};
		System.out.println(maxIncreaseKeepingSkyline(grid));
	}

}
