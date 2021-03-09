import java.util.LinkedHashMap;
import java.util.Map;

public class TestLinkedHashMap {

    public static void main(String[] args) {

        TestLinkedHashMap testLinkedHashMap = new TestLinkedHashMap();
        testLinkedHashMap.test1();
        System.out.println();
        testLinkedHashMap.test2();


    }

    // accessOrder = false ，插入顺序迭代
    private void test1() {
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();

        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);

        map.get(1);// 访问链表头结点不会改变迭代顺序
        map.put(2, 3);// 改变已有值不会改变迭代顺序
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry);
        }
    }

    // accessOrder = true ，访问顺序迭代
    private void test2() {
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>(4, (float) 0.75,true);

        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);

        map.get(1);// 访问链表头结点会改变迭代顺序
        map.put(2, 3);// 改变旧值会改变迭代顺序

        map.put(4, 4);
        map.put(5, 5);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry);
        }
    }
}
