import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test1 {


    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        int[] a = list.stream().mapToInt(Integer::intValue).toArray();
    }
}
