package singlecase.case01;

/**
 * @author LiuNaiJie
 * on 2019-10-14
 */
public class Case1 {

	public static void main(String[] args) {
		//Single s1 = new Single(); // 无法在其它类中通过 new 进行实例化，保证了不会由其它类产生实例

		Single s1 = Single.getInstance();
		Single s2 = Single.getInstance();
		System.out.println(s1 == s2);
		System.out.println("s1的hashcode" + s1.hashCode());
		System.out.println("s2的hashcode" + s2.hashCode());
	}

}

/**
 * 饿汉式的单例模式
 * 优点：写法简单。在类装载时就完成了实例化。线程安全
 * 缺点：在类装载时就进行了实例化，如果从始至终没有用到这个实例，会造成内存浪费
 */
class Single {
	/**
	 * 设置成私有的，保证无法在其它类中使用 new 关键字进行实例化
	 */
	private Single() {

	}

	private final static Single INSTANCE = new Single();

	public static Single getInstance() {
		return INSTANCE;
	}

}

/**
 * 与上面的类似，用了静态代码块
 */
class SingleTest2 {

	private SingleTest2() {

	}

	private static SingleTest2 SINGLE_TEST_2;

	static {
		SINGLE_TEST_2 = new SingleTest2();
	}

	/**
	 *
	 * @return
	 */
	public static SingleTest2 getInstance() {
		return SINGLE_TEST_2;
	}


}