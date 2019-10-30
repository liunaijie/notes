package singlecase.case02;

/**
 * 懒汉式：在需要使用时再去初始化对象实例，如果用不到则不会消耗内存，使用双重检查保证了线程安全性
 * @author LiuNaiJie
 * on 2019-10-14
 */
public class Case2 {
	public static void main(String[] args) {
		SafeSingle s1 = SafeSingle.getInstance();
		SafeSingle s2 = SafeSingle.getInstance();
		System.out.println(s1 == s2);
		System.out.println("s1的hashcode" + s1.hashCode());
		System.out.println("s2的hashcode" + s2.hashCode());
	}
}

/**
 * 懒汉式的单例模式
 * 线程不安全
 */
class UnSafeSingle {

	private UnSafeSingle() {
	}

	private static UnSafeSingle INSTANCE;

	public static UnSafeSingle getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new UnSafeSingle();
		}
		return INSTANCE;
	}

}

/**
 * 通过加锁的方式实现线程安全的懒汉式单例
 * 由于获取单例的方法每次都需要进行同步，所以效率不高
 */
class SynchronizedSingle {
	private SynchronizedSingle() {
	}

	private static SynchronizedSingle INSTANCE;

	public static synchronized SynchronizedSingle getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new SynchronizedSingle();
		}
		return INSTANCE;
	}
}

/**
 * 双重检查
 * 当使用getInstance()方法时不会进行同步，先进行判断。
 * 由于使用了 volatile 关键字，即便又两个线程同时执行了这个方法，只要有一个线程对变量进行了修改，另外一个线程也能接收到更改的信号
 */
class SafeSingle{

	private SafeSingle(){}

	private static volatile SafeSingle INSTANCE;

	public static SafeSingle getInstance(){
		if(INSTANCE==null){
			synchronized (SafeSingle.class){
				if(INSTANCE==null){
					INSTANCE = new SafeSingle();
				}
			}
		}
		return INSTANCE;
	}

}