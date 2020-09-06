package cn.edu.scu.gof.test;

public class Test {
	public static void main(String[] args) {
		String a = new String("abc");
		String b = new String("abc");
		System.out.println(a == b);
		System.out.println(a.equals(b));
		System.out.println(a.getClass());
	}
}
