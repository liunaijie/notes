/**
 * 红黑树
 *
 * @author ：LiuNaiJie
 * @date ：2019-12-23
 */
public class RedBlackTree<E extends Comparable<E>> {

	public static void main(String[] args) throws IllegalAccessException {
		RedBlackTree<Integer> redBlackTree = new RedBlackTree<Integer>();
		redBlackTree.add(1);
		redBlackTree.add(3);
		redBlackTree.add(5);
		redBlackTree.add(7);
		redBlackTree.add(9);
		redBlackTree.add(2);
		redBlackTree.add(4);
		redBlackTree.printTree();
		System.out.println();
		redBlackTree.remove(2);
		redBlackTree.printTree();
		System.out.println();
		redBlackTree.remove(11);
	}

	RedBlackTreeNode<E> head;


	public void add(E val) throws IllegalAccessException {
		if (val == null) {
			throw new IllegalAccessException("不能添加null值");
		}
		head = addVal(val, head);
		//最终将根节点设置为黑色
		head.color = BLACK;
	}

	public void remove(E val) throws IllegalAccessException {
		if (val == null) {
			throw new IllegalAccessException("不允许null值操作");
		}
		if (head == null) {
			throw new IllegalAccessException("树为空");
		}
		head = removeVal(val, head);
	}

	private RedBlackTreeNode<E> removeVal(E val, RedBlackTreeNode<E> node) throws IllegalAccessException {
		if (node == null) {
			throw new IllegalAccessException("val not exist!");
		}
		if (val.compareTo(node.val) < 0) {
			node.left = removeVal(val, node.left);
		} else if (val.compareTo(node.val) > 0) {
			node.right = removeVal(val, node.right);
		} else {
			if (node.right != null) {
				node = getRightMinNode(node);
			} else if (node.left != null) {
				node = getLeftMaxNode(node);
			} else {
				node = null;
			}
		}
		if (node != null) {
			//判断平衡等操作
			if (isRed(node.right) && !isRed(node.left)) {
				//右节点为红色，左节点为空或者黑色时需要进行左旋
				node = rotateLeft(node);
			}
			if (isRed(node.left) && isRed(node.left.left)) {
				//左节点为红色，左节点的左节点也为红色时，需要进行右旋
				node = rotateRight(node);
			}
			if (isRed(node.left) && isRed(node.right)) {
				//当两个子节点都为红色时，需要进行变色
				flipColor(node);
			}
		}
		return node;
	}

	/**
	 * 获取右侧树的最小节点
	 *
	 * @param node
	 * @return
	 */
	private RedBlackTreeNode<E> getRightMinNode(RedBlackTreeNode<E> node) {
		RedBlackTreeNode<E> parent = node.right;
		if (parent.left == null) {
			node.right = parent.right;
			return parent;
		}
		RedBlackTreeNode<E> result = parent.left;
		//可能有优化的地方
		while (result.left != null) {
			parent = parent.left;
			result = parent.left;
		}
		parent.left = null;
		return result;
	}


	private RedBlackTreeNode<E> getLeftMaxNode(RedBlackTreeNode<E> node) {
		RedBlackTreeNode<E> parent = node.left;
		if (parent.right == null) {
			node.right = parent.left;
			return parent;
		}
		RedBlackTreeNode<E> result = parent.right;
		while (result.right != null) {
			parent = parent.right;
			result = parent.right;
		}
		parent.right = null;
		return result;
	}


	/**
	 * 中序打印树
	 */
	public void printTree() {
		print(head);
	}

	private void print(RedBlackTreeNode<E> node) {
		if (node == null) {
			return;
		}
		print(node.left);
		System.out.print(node.val + " ");
		print(node.right);
	}

	private RedBlackTreeNode<E> addVal(E val, RedBlackTreeNode<E> node) {
		//达到最终的节点，如果为空则新建一个红色的节点
		if (node == null) {
			return new RedBlackTreeNode<E>(val);
		}
		if (val.compareTo(node.val) < 0) {
			//如果小，则左节点为 新建节点返回的节点(可能会经过调整)
			node.left = addVal(val, node.left);
		} else if (val.compareTo(node.val) > 0) {
			//如果大，则右节点为  新建节点后返回的节点(可能会经过调整)
			node.right = addVal(val, node.right);
		} else {
			//值相等
			return node;
		}
		//判断平衡等操作
		if (isRed(node.right) && !isRed(node.left)) {
			//右节点为红色，左节点为空或者黑色时需要进行左旋
			node = rotateLeft(node);
		}
		if (isRed(node.left) && isRed(node.left.left)) {
			//左节点为红色，左节点的左节点也为红色时，需要进行右旋
			node = rotateRight(node);
		}
		if (isRed(node.left) && isRed(node.right)) {
			//当两个子节点都为红色时，需要进行变色
			flipColor(node);
		}
		return node;
	}

	private boolean isRed(RedBlackTreeNode<E> node) {
		if (node == null) {
			return false;
		}
		return node.color;
	}

	/**
	 * 左旋操作
	 *
	 * @param node
	 * @return
	 */
	private RedBlackTreeNode<E> rotateLeft(RedBlackTreeNode<E> node) {
		//变换位置
		RedBlackTreeNode<E> result = node.right;
		node.right = result.left;
		result.left = node;
		//换色
		result.color = node.color;
		node.color = RED;
		return result;
	}

	/**
	 * 右旋操作
	 *
	 * @param node
	 * @return
	 */
	private RedBlackTreeNode<E> rotateRight(RedBlackTreeNode<E> node) {
		//变换位置
		RedBlackTreeNode<E> result = node.left;
		node.left = result.right;
		result.right = node;
		//变色
		result.color = node.color;
		node.color = RED;
		return result;
	}

	/**
	 * 变换颜色
	 * 如果左右子节点都为红色，则进行变色，左右子节点都为黑色，父节点为红色
	 *
	 * @param node
	 */
	private void flipColor(RedBlackTreeNode<E> node) {
		node.left.color = BLACK;
		node.right.color = BLACK;
		node.color = RED;
	}

	private static final boolean RED = true;
	private static final boolean BLACK = false;

	/**
	 * 红黑树的节点结构
	 * 保存的值，左节点，右节点以及颜色(true为红色，false为黑色)
	 * 默认添加一个红节点
	 *
	 * @param <E>
	 */
	static final class RedBlackTreeNode<E extends Comparable<E>> {

		E val;
		RedBlackTreeNode<E> left;
		RedBlackTreeNode<E> right;
		boolean color = RED;


		RedBlackTreeNode(E val) {
			this.val = val;
		}

	}

}