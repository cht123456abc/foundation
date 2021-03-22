package cn.edu.scu.exam;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 水仙花数
 *
 * （编程题须知） （参考答案）
 *
 * 时间限制： 4000MS
 * 内存限制： 557056KB
 * 题目描述：
 * 春天是鲜花的季节，水仙花就是其中最迷人的代表，数学上有个水仙花数，他是这样定义的： “水仙花数”是指一个三位数，它的各位数字的立方和等于其本身，比如：153=1^3+5^3+3^3。 现在要求输出所有在m和n范围内的水仙花数。
 *
 *
 *
 * 输入描述
 * 输入数据有多组，每组占一行，包括两个整数m和n（100<=m<=n<=999）。
 *
 * 输出描述
 * 对于每个测试实例，要求输出所有在给定范围内的水仙花数，就是说，输出的水仙花数必须大于等于m,并且小于等于n，如果有多个，则要求从小到大排列在一行内输出，之间用一个空格隔开; 如果给定的范围内不存在水仙花数，则输出no; 每个测试实例的输出占一行。
 *
 *
 * 样例输入
 * 100 120
 * 300 380
 *
 * 样例输出
 * no
 * 370 371
 */
public class 水仙花数 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String nm = scanner.nextLine();
            String[] nms = nm.split(" ");
            int m = Integer.parseInt(nms[0]);
            int n = Integer.parseInt(nms[1]);

            List<String> res = new ArrayList<>();

            for (int i = m; i <=n ; i++) {

                int a = i;
                int sum = 0;
                while (a > 0) {
                    int b = a % 10;
                    sum += Math.pow(b, 3);
                    a = a / 10;
                }
                if(sum == i) res.add(String.valueOf(i));
            }
            if (res.isEmpty()) {
                System.out.println("no");
            } else {
                System.out.println(String.join(" ",res));
            }

        }

    }
}
