package top.lnj.leetcode.editor.cn;

import java.util.Arrays;

/**
 * 最小的k个数
 *
 * @author ：LiuNaiJie
 * @date ：2020-04-13
 */
public class M40 {

	/**
	 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
	 * 示例 1：
	 * 输入：arr = [3,2,1], k = 2
	 * 输出：[1,2] 或者 [2,1]
	 * 示例 2：
	 * 输入：arr = [0,1,2,1], k = 1
	 * 输出：[0]
	 * 限制：
	 * 0 <= k <= arr.length <= 10000
	 * 0 <= arr[i] <= 10000
	 */

	/**
	 * 使用堆来完成
	 *
	 * @param arr
	 * @param k
	 * @return
	 */
	public int[] getLeastNumbersHeap(int[] arr, int k) {
		if (k == 0 || arr.length == 0) {
			return new int[0];
		}
		M40HeapHelp heap = new M40HeapHelp(k);
		for (int i : arr) {
			heap.add(i);
		}
		return heap.getHeap();
	}

	/**
	 * 求最小值，先排序，然后求前k个
	 *
	 * @param arr
	 * @param k
	 * @return
	 */
	public int[] getLeastNumbersSort(int[] arr, int k) {
		Arrays.sort(arr);
		int[] result = new int[k];
		System.arraycopy(arr, 0, result, 0, k);
		return result;
	}

	/**
	 * 使用快排的思想
	 *
	 * @param arr
	 * @param k
	 * @return
	 */
	public int[] getLeastNumbersQuickSort(int[] arr, int k) {
		if (k == 0 || arr.length == 0) {
			return new int[0];
		}
		//由于返回的是元素下标，所以为长度-1
		return quickSortHelp(arr, 0, arr.length - 1, k - 1);
	}


	private int[] quickSortHelp(int[] arr, int left, int right, int k) {
		//快排是用到了分区点这个概念，会将小于分区点的元素放到左边，大于分区点的元素放到右边。
		//如果分区点左边的元素是k个或k-1个，那么我们就获取到了最小的k个元素
		//当元素数量小于k时，我们需要向右分，当数量大于k时需要向左分，直到获取到k个元素
		SortUtil sortUtil = new SortUtil();
		int[] result = new int[k];
		int partition = sortUtil.partition(arr, left, right);
		if (partition == k) {
			System.arraycopy(arr, 0, result, 0, k);
			return result;
		}
		return partition > k ? quickSortHelp(arr, left, partition - 1, k) : quickSortHelp(arr, partition + 1, right, k);
	}


	/**
	 * 使用堆来实现，求最小的k个数，构建一个k个元素的最大堆，这个最大堆里面存储最小的k个数
	 * 首先将前k个元素存储，后面的与最大值比较，如果比最大值小，那么就删除最大值再将值添加到堆里面
	 */
	private class M40HeapHelp {
		private int[] heap;
		private int count;
		private int length;

		public M40HeapHelp(int capacity) {
			this.heap = new int[capacity + 1];
			count = 0;
			length = capacity;
		}


		public void add(int val) {
			if (count >= length) {
				//当堆内元素超过最大值后进行判断
				if (val < heap[1]) {
					//如果要插入的元素比堆内的最大值小，则将最大值删除，后面将值进行插入
					removeTop();
				} else {
					//否则直接返回
					return;
				}
			}
			addVal(val);
		}

		private void addVal(int val) {
			//数量加一
			++count;
			//将值添加到最后一个位置
			heap[count] = val;
			//此时可能破坏了堆的规则，所以需要重新建堆
			int i = count;
			//判断是否需要与父节点进行替换
			while (i / 2 > 0 && heap[i] > heap[i / 2]) {
				//首先是数组越界判断，然后判断当前节点是否比父节点大，如果大则需要替换
				int temp = heap[i / 2];
				heap[i / 2] = heap[i];
				heap[i] = temp;
				//然后向上继续判断
				i = i / 2;
			}

		}

		public void removeTop() {
			if (count <= 0) {
				//堆内没有元素
				return;
			}
			//将堆内的最后一个元素放到最大值位置上，
			heap[1] = heap[count];
			//数量减一
			--count;
			//这时堆可能不满足堆的规则，需要进行重新建堆
			rebuildHeap(heap, count, 1);
		}

		private void rebuildHeap(int[] a, int n, int i) {
			while (true) {
				//当前节点的数据可能比子节点的数据大，所以与两个子节点对比，找到最大值后进行替换
				int maxPos = i;
				//需要注意不能下标越界
				if (i * 2 <= n && a[i] < a[i * 2]) {
					maxPos = i * 2;
				}
				//先判断左子节点，然后判断左子节点与右子节点的大小
				if (i * 2 + 1 <= n && a[maxPos] < a[i * 2 + 1]) {
					maxPos = i * 2 + 1;
				}
				if (maxPos == i) {
					//如果父节点比两个子节点都大，则不需要替换满足条件，直接返回
					break;
				}
				//将父节点与最大子节点进行替换
				int temp = a[i];
				a[i] = a[maxPos];
				a[maxPos] = temp;
				//然后递归判断子节点是否满足条件，直到满足条件后退出
				i = maxPos;
			}
		}

		/**
		 * 返回堆的内容，由于堆是从1开始存放，所以将结果重新放到新数组中，从0开始放。
		 *
		 * @return
		 */
		public int[] getHeap() {
			int[] result = new int[count];
			System.arraycopy(heap, 1, result, 0, count);
			return result;
		}

	}

}
