package cn.edu.scu.exam;

import java.math.BigInteger;
import java.util.*;

/**
 * 寻找数字
 * 时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 * 小美过冬之前将很多数藏进一个仅包含小写英文字母的字符串。在冬天她想将所有数找回来，请帮帮她。
 *
 * 给定一个字符串s，仅包含小写英文字母和数字，找出其中所有数。一个数是指其中一段无法延伸的连续数字串。如a1254b中仅包含1254这一个数，125则不是，因为125还可以向右延伸成1254。如果该字符串包含前导零，则抹掉前导零。
 *
 * 例如a0125b1c0d00中包含四个数0125，1，0，00，按照规则抹掉前导零后，最终这个字符串包含的四个数为125，1，0，0。即，0125->125，00->0，其中1和0无前导零，无需变更。
 *
 *
 *
 * 输入描述
 * 输入一行，一个仅包含小写英文字母和数字的字符串s。
 *
 * 1≤s的长度≤1010
 *
 * 输出描述
 * 输出若干行，表示找到的所有数。按从小到大的顺序输出。
 *
 *
 * 样例输入
 * He15l154lo87wor7l87d
 * 样例输出
 * 7
 * 15
 * 87
 * 87
 * 154
 */
public class 找出字符串中的数字 {

    public static void main(String[] args) {


        // 找数字，并排序输出
        Scanner scanner = new Scanner(System.in);


        String line = scanner.nextLine();

        List<Integer> res = new ArrayList<>();

        char[] ss = line.toCharArray();
        StringBuilder number = new StringBuilder();
        for (int i = 0; i < ss.length; i++) {
            char c = ss[i];

            if (Character.isDigit(c)) {
                number = number.append(c);
            } else {
                if (number.length() > 0) {
                    res.add(Integer.parseInt(number.toString()));
                    number = new StringBuilder();
                }
            }
        }
        if (number.length() > 0) {
            res.add(Integer.parseInt(number.toString()));
        }


        Collections.sort(res);

        res.forEach(System.out::println);
    }
}
