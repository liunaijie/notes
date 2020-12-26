/**
 * @author ：LiuNaiJie
 * @date ：2020-04-03
 */
public class T33 {

	public int search(int[] a, int value) {
		int n = a.length;
		int left = 0, right = n - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (a[mid] == value) {
				return mid;
			}
			if (a[left] <= a[mid]) {
				//这时说明数组前一部分是有序的
				if (value >= a[left] && value <= a[mid]) {
					//要查找的值在前一部分的有序区间内
					right = mid - 1;
				} else {
					//当要查找的值比开始值小，比结束值大的情况都向mid右边查找
					//比开始值小，有两种情况，在开始值左边（单调递增），在结束值右边（拆分递增）
					//对于在结束值右边的情况，那么肯定是left=mid+1
					//对于在左边的情况，由于是从上到下的，这种情况是不会出现的，在上一层进行了保证
					//举例： [14,15,1,2,3,4,5,6,7,8,9,10,11,12,13]。我们是不会拿到[3,4,5,6]去查找1的，因为在[14,15,1,2,3,4,5,6]这个里面就进行了判断
					left = mid + 1;
				}
			} else {
				//这时说明数组前一部分无序，后一部分有序
				if (value > a[mid] && value <= a[right]) {
					//要查找的值在后一部分的有序区间内
					left = mid + 1;
				} else {
					//当查找值比开始值小，比结束值大的情况向左边查找
					right = mid - 1;
				}
			}
		}
		return -1;
	}

}
