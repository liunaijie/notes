/**
 * 排序工具类
 *
 * @author ：LiuNaiJie
 * @date ：2020-03-04
 */
public class SortUtil {


	/**
	 * 冒泡排序
	 * 第一层循环相当于一次冒泡，将最大值冒泡到未排序数组最后的位置
	 *
	 * @param a 待排序数组
	 */
	public void bubbleSort(int[] a) {
		int n = a.length;
		if (n <= 1) {
			return;
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (a[j] > a[j + 1]) {
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}
	}

	/**
	 * 优化版的冒泡排序
	 * 当数组已经有序时，退出排序
	 *
	 * @param a 待排序数组
	 */
	public void bubbleSortBetter(int[] a) {
		int n = a.length;
		if (n <= 1) {
			return;
		}
		for (int i = 0; i < n; i++) {
			boolean flag = true;
			for (int j = 0; j < n - i - 1; j++) {
				if (a[j] > a[j + 1]) {
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
					// 表示有数据交换
					flag = true;
				}
			}
			if (!flag) {
				//没有数据交换时，提前退出
				break;
			}
		}
	}

	/**
	 * 插入排序
	 * 思想是，将第一个元素看作数组，然后从第二个位置开始插入到这个数组中
	 * 插入一次后，再将第三个元素插入到已排序好的一二元素构成的数组中
	 *
	 * @param a 待排序的数组
	 */
	public void insertionSort(int[] a) {
		int n = a.length;
		//入参判断
		if (n <= 1) {
			return;
		}
		//从第二个开始插入到已排序数组中，（前面i个为已排序数组）
		for (int i = 1; i < n; i++) {
			int value = a[i];
			int j = i - 1;
			//查找插入的位置
			//从后向前查找要插入的位置
			// 因为如果从前开始也要先找到位置，然后将位置后的元素进行向后移动，次数为已排序数组的长度
			// 从后面查找的话，最坏情况是已排序数组的长度
			for (; j >= 0; j--) {
				if (a[j] > value) {
					a[j + 1] = a[j];
				} else {
					break;
				}
			}
			//进行插入
			a[j + 1] = value;
		}
	}

	/**
	 * 改进的插入排序- 希尔排序
	 * 比插入排序和选择排序快得多，并且数组越大，优势越大
	 *
	 * @param a 待排序的数组
	 */
	public static void shellSort(int[] a) {
		int n = a.length;
		int h = 1;
		//增量计算
		while (h < n / 3) {
			h = 3 * h + 1;
		}
		while (h >= 1) {
			//对一个组的元素进行排序
			for (int i = h; i < n; i++) {
				for (int j = i; j >= h; j -= h) {
					if (a[j] < a[j - h]) {
						int temp = a[j - h];
						a[j - h] = a[j];
						a[j] = temp;
					}
				}
			}
			//增量递减，逐渐缩小数组
			h = h / 3;
		}
	}

	/**
	 * 选择排序
	 * 也是分为未排序数组和已排序数组，刚开始未排序数组为全部，已排序数组为零
	 * 然后从未排序数组中找到最小值，放到已排序数组中，即第一个位置
	 * 然后再从未排序数组中找最小值，放到已排序数组的末尾，即第二个位置
	 *
	 * @param a 待排序的数组
	 */
	public void selectionSort(int[] a) {
		int n = a.length;
		for (int i = 0; i < n; i++) {
			int minIndex = i;
			//找到未排序数组中最小的元素
			for (int j = i + 1; j < n; j++) {
				if (a[j] < a[minIndex]) {
					minIndex = j;
				}
			}
			//将找到的元素与已排序数组的尾部进行交换。
			int temp = a[minIndex];
			a[minIndex] = a[i];
			a[i] = temp;
		}
	}

	/**
	 * 归并排序
	 * 分治的思想。
	 * 将数组拆分，一分为二，然后拆分出来的数组再继续拆分，直至不能拆分，即只有一个元素了。
	 * 然后合并，将两个数组合并，最底层就是将两个元素合并，先将它们排序放到临时数组中，再将临时数组中的元素复制到这两个数组对应的位置上
	 * 最后合并成一个数组，这个数组就是有序的了
	 *
	 * @param a 待排序数组
	 */
	public void mergeSort(int[] a) {
		if (a == null) {
			return;
		}
		mergeSortHelp(a, 0, a.length - 1);
	}

	/**
	 * 对数组进行递归拆分，然后在进行合并
	 * 直到拆分到单个元素，然后再向上合并
	 *
	 * @param a     待排序数组
	 * @param start 开始位置
	 * @param end   结束位置
	 */
	private void mergeSortHelp(int[] a, int start, int end) {
		//递归函数边界退出条件
		if (start >= end) {
			return;
		}
		int mid = (start + end) / 2;
		mergeSortHelp(a, start, mid);
		mergeSortHelp(a, mid + 1, end);
		mergeHelp(a, start, mid, end);
	}

	/**
	 * 合并函数
	 * 将左边到中间看作一个数组，中间到右边看作一个数组，先将这两个数组排序合并到一个临时数组中
	 * 然后再将这个临时数组中的内容复制到原数组的从left到right的位置上
	 *
	 * @param a     待排序数组，原数组
	 * @param left  开始位置
	 * @param mid   中间位置
	 * @param right 结束位置
	 */
	private void mergeHelp(int[] a, int left, int mid, int right) {
		int[] temp = new int[right - left + 1];
		int i = left, j = mid + 1, k = 0;
		while (i <= mid && j <= right) {
			if (a[i] <= a[j]) {
				temp[k++] = a[i++];
			} else {
				temp[k++] = a[j++];
			}
		}
		//将左边剩余元素填充到temp中
		while (i <= mid) {
			temp[k++] = a[i++];
		}
		//将右边剩余元素填充到temp中
		while (j <= right) {
			temp[k++] = a[j++];
		}
		//将temp中的元素全部拷贝到原数组中
		System.arraycopy(temp, 0, a, left, k);
	}

	/**
	 * 快速排序
	 *
	 * @param a 待排序数组
	 */
	public void quickSort(int[] a) {
		int n = a.length;
		quickSortHelp(a, 0, n - 1);
	}

	private void quickSortHelp(int[] a, int start, int end) {
		//递归函数边界退出条件
		if (start >= end) {
			return;
		}
		int p = partition(a, start, end);
		quickSortHelp(a, start, p - 1);
		quickSortHelp(a, p + 1, end);
	}

	/**
	 * 获取分区点下标
	 *
	 * @param a     待排序数组
	 * @param left  要分区的左侧下标
	 * @param right 要分区的右侧下标
	 * @return
	 */
	private int partition(int[] a, int left, int right) {
		//设置分区点为数组最后一个元素
		int pivot = a[right];
		//开始分区
		int i = left;
		for (int j = left; j < right - 1; j++) {
			if (a[j] < pivot) {
				//如果元素比分区点小，则将元素从左侧开始放，将原来左侧的数据换到现在这个位置上
				//i表示左侧的位置，交换后就加一
				swap(a, i, j);
				i++;
			}
		}
		//最后将分区点放到对应位置上
		//交换后，i左侧为比分区点小的元素，右侧为比分区点大的元素
		swap(a, i, right);
		return i;
	}

	private void swap(int[] a, int first, int second) {
		int temp = a[first];
		a[first] = a[second];
		a[second] = temp;
	}


	public static void main(String[] args) {
		int[] a = {6, 3, 1, 8, 2, 9, 4, 7};
//		mergeSort(a);
		for (int i : a) {
			System.out.print(i + " ");
		}
	}

}
