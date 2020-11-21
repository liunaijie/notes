package top.lnj.leetcode;

import java.util.Arrays;

/**
 * 有序数组的平方
 *
 * @author ：LiuNaiJie
 * @date ：2020-03-14
 */
public class T977 {

	public int[] sortedSquares(int[] A) {
		for (int i : A) {
			A[i] *= A[i];
		}
		Arrays.sort(A);
		return A;
	}

	public int[] sortedSquaresDouble(int[] A) {
		//先找到正数负数的分解
		int length = A.length;
		int j = 0;
		while (j < length && A[j] < 0) {
			j++;
		}
		//负数最后的下标
		int i = j - 1;
		int[] res = new int[length];
		int index = 0;
		while (i >= 0 && j < length) {
			if (A[i] * A[i] < A[j] * A[j]) {
				res[index++] = A[i] * A[i];
				i--;
			} else {
				res[index++] = A[j] * A[j];
				j++;
			}
		}
		//再将两边剩余的部分添加到数组中
		while (i >= 0) {
			res[index++] = A[i] * A[i];
			i--;
		}
		while (j < length) {
			res[index++] = A[j] * A[j];
			j++;
		}
		return res;
	}

}
