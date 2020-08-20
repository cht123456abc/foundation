import java.util.Arrays;
import java.util.List;

public class TestArraysAsList {

    public static void main(String[] args) {

        int[] a = new int[]{1, 2, 3};
        List list = Arrays.asList(a);
//        list.add(4);
        list.stream().forEach(System.out::println);
        Arrays.stream(a).forEach(System.out::println);
    }
}
