/**
 * 堆
 *
 * @author ：LiuNaiJie
 * @date ：2020-03-08
 */
public class Heap {

	/**
	 * 堆是一种特殊的树，需要满足下面这两点是树才是堆
	 * - 堆是一个完全二叉树
	 * - 对中每一个节点的值都必须大于等于(或小于等于)其子树中每个节点的值。
	 * 来看两个例子：
	 * 大顶堆，每个节点的值都大于等于子树中每个节点值：
	 * 			10
	 * 		9		8
	 * 	6	  5	  7 	4
	 * 3
	 * 小顶堆，每个节点的值都小于等于子树中每个节点值：
	 * 			3
	 * 		4		6
	 * 	  5	  8	  9	  10
	 * 	7
	 * 	堆可以用数组存储，可以单独通过数组的下标，就可以找到一个节点的左右节点和父节点
	 * 	数组中下标为i的节点的左右节点，就是下标为i*2的节点，右子节点就是下标为i*2+1的节点
	 * 	父节点就是下标为i/2的节点。
	 * 	例如上面的两个堆，分别可以用这两个数组表示：
	 * 	10,9,8,6,5,7,4,3
	 * 	3,4,6,5,8,9,10,7
	 */

	/**
	 * 数组，从下标1开始存储数据
	 */
	private int[] a;
	/**
	 * 堆可以存储的最大数据个数
	 */
	private int n;
	/**
	 * 堆中已经存储的数据个数
	 */
	private int count;

	public Heap(int capacity) {
		a = new int[capacity + 1];
		n = capacity;
		count = 0;
	}

	/**
	 * 向堆内插入
	 *
	 * @param data
	 */
	public void insert(int data) {
		if (count >= n) {
			//堆满了
			return;
		}
		++count;
		a[count] = data;
		int i = count;
		while (i / 2 > 0 && a[i] > a[i / 2]) {
			int temp = a[i];
			a[i] = a[i / 2];
			a[i / 2] = temp;
			i = i / 2;
		}
	}

	public void removeMax() {
		if (count == 0) {
			//堆内没有数据
			return;
		}
		a[1] = a[count];
		--count;
		heapHelp(a, count, 1);
	}

	private void heapHelp(int[] a, int n, int i) {
		while (true) {
			int maxPos = i;
			if (i * 2 <= n && a[i] < a[i * 2]) {
				maxPos = i * 2;
			}
			if (i * 2 + 1 <= n && a[maxPos] < a[i * 2 + 1]) {
				maxPos = i * 2 + 1;
			}
			if (maxPos == i) {
				break;
			}
			int temp = a[i];
			a[i] = a[maxPos];
			a[maxPos] = temp;
			i = maxPos;
		}
	}

	public int[] getHeap() {
		int[] r = new int[count];
		System.arraycopy(a, 1, r, 0, count);
		return r;
	}

}
