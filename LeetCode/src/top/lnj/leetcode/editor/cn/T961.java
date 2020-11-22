package top.lnj.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author LiuNaiJie
 * on 2019-07-12
 */
public class T961 {

	public int repeatedNTimes(int[] A) {
		Arrays.sort(A);
		for (int i = 0; i < A.length - 1; i++) {
			if (A[i] == A[i + 1]) {
				return A[i];
			}
		}
		return 0;
	}

	public int repeatedNTimesHash(int[] A) {
		Set<Integer> set = new HashSet<>(A.length);
		for (int i : A) {
			if (set.contains(i)) {
				return i;
			}
			set.add(i);
		}
		return -1;
	}

}
