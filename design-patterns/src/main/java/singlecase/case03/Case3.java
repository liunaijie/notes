package singlecase.case03;

/**
 * 使用静态内部类实现单例模式
 *  通过类加载的机制来保证初始化实例时只有一个线程
 *  静态内部类方式在外部类装载时不会立即实例化，而是在需要实例化时，调用getInstance()方法，才会装载内部类，从而完成外部类的实例化。
 * @author LiuNaiJie
 * on 2019-10-14
 */
public class Case3 {

	public static void main(String[] args) {
		Single s1 = Single.getInstance();
		Single s2 = Single.getInstance();
		System.out.println(s1 == s2);
		System.out.println("s1的hashcode" + s1.hashCode());
		System.out.println("s2的hashcode" + s2.hashCode());
	}
}

/**
 * 线程安全，实现了懒加载
 */
class Single {

	private Single() {
	}

	/**
	 * 内部类在getInstance()方法被调用时才会被加载
	 */
	private static class InSingle {
		private static final Single INSTANCE = new Single();
	}

	public static Single getInstance() {
		return InSingle.INSTANCE;
	}

}