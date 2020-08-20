import java.util.ArrayList;
import java.util.List;

public class TestArrayList {

    public static void main(String[] args) {

        List<List<Integer>> list = new ArrayList<>();
        List<Integer> level1 = new ArrayList<>();
        level1.add(1);
        level1.add(2);
        level1.add(3);
        List<Integer> level2 = new ArrayList<>();
        level2.add(1);
        level2.add(2);
        level2.add(3);
        List<Integer> level3 = new ArrayList<>();
        level3.add(1);
        level3.add(2);
        level3.add(null);
        list.add(level1);
        list.add(level2);
        list.add(level3);
        list.stream().flatMap(List::stream).forEach(System.out::println);
        StringBuilder sb = new StringBuilder();
        sb.append("1").append(",").append("2").append(",");
        sb.deleteCharAt(sb.lastIndexOf(","));
        System.out.println(sb.toString());
        System.out.println(sb.toString().split(",").length);

    }
}
