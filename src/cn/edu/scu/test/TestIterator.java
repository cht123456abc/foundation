package cn.edu.scu.test;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// 测试迭代器
public class TestIterator {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        // 对list进行迭代删除的正确姿势
        Iterator<Integer> iter = list.iterator();
        while (iter.hasNext()) {
            int i = iter.next();
            if(i % 2 == 0) iter.remove();
        }
        list.stream().forEach(System.out::println);

//         错误方式一:
//        for (Integer integer : list) {
//            if (integer % 2 == 0) list.remove(integer);// 会报ConcurrentModifiedException
//        }
//        list.stream().forEach(System.out::println);

//         错误方式二：
//        for (int i = 0; i < list.size(); i++) {
//            if (list.get(i) == 2) {
//                list.remove(2); // 会漏掉一个2
//                i--;// 解决办法时将序号往前移
//            }
//        }
//        list.stream().forEach(System.out::println);
    }
}
