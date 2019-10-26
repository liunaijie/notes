package chart1;

/**
 * @author LiuNaiJie
 * on 2019-10-26
 */
public class T1_1_13 {

	/**
	 * 编写一段代码，打印出一个 M 行 N 列的二维数组的转置（交换行和列）
	 *
	 * @param array M 行 N 列的二维数组
	 */
	static void changeArray(int[][] array) {
		int M = array.length;
		int N = array[0].length;
		int[][] change = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				//交换内容
				change[i][j] = array[j][i];
				//打印
				System.out.print(change[i][j] + " ");
				//换行
				if (j == M - 1) {
					System.out.println();
				}
			}
		}
	}

	public static void main(String[] args) {
		int[][] array = {{1, 2}, {3, 4}, {5, 6}};
		changeArray(array);
	}

}
