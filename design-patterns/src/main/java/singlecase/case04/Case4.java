package singlecase.case04;

/**
 * 利用枚举来实现单例模式
 *
 * @author LiuNaiJie
 * on 2019-10-15
 */
public class Case4 {

	public static void main(String[] args) {
		Single s1 = Single.INSTANCE;
		Single s2 = Single.INSTANCE;
		System.out.println(s1 == s2);
		System.out.println("s1的hashcode" + s1.hashCode());
		System.out.println("s2的hashcode" + s2.hashCode());
		s1.sayHello("test");
	}

}

/**
 * 枚举能避免多线程产生多个实例的问题，还能防止反序列化重新创建新的对象
 */
enum Single {

	INSTANCE;


	public void sayHello(String name) {
		System.out.println("hello," + name);
	}

}
