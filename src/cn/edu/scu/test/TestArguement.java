package cn.edu.scu.test;

/**
 * 测试java的引用传递
 */
public class TestArguement {

    // java 实际上是值传递，函数内改变引用不能起作用
    public void function(Integer a,Boolean b,String c,Integer[] d){
        a = 22;
        b = true;
        c = "aaa";// 不能改变引用本身
        d[0] = 2;// 但是可以改变引用对象里面的值
    }

    public static void main(String[] args) {

        Integer a = 11;
        Boolean b = false;
        String c = "bbb";
        Integer[] d = new Integer[]{1};
        TestArguement testArguement = new TestArguement();
        testArguement.function(a,b,c,d);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d[0]);
    }
}
