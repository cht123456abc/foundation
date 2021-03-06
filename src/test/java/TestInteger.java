import org.junit.Test;

public class TestInteger {
    public static void main(String[] args) {
        Integer a = 123;
        Integer b = 123;

        System.out.println(a == b);

        Integer c = 128;
        Integer d = 128;

        System.out.println(c == d);

        Integer e = 123;
        Integer f = new Integer(123);

        System.out.println(e == f);

    }

    @Test
    public void testMaxValue() {
        long a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;
        System.out.println(a + 1);
        System.out.println(b + 1);
    }

}
