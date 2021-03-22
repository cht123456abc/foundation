package cn.edu.scu.exam;

import java.text.NumberFormat;
import java.util.Scanner;

/**
 * 求数列的和
 *
 * （编程题须知）（参考答案）
 *
 * 时间限制： 4000MS
 * 内存限制： 557056KB
 * 题目描述：
 * 数列的定义如下： 数列的第一项为n，以后各项为前一项的平方根，求数列的前m项的和。
 *
 *
 *
 * 输入描述
 * 输入数据有多组，每组占一行，由两个整数n（n<10000）和m(m<1000)组成，n和m的含义如前所述。
 *
 * 输出描述
 * 对于每组输入数据，输出该数列的和，每个测试实例占一行，要求精度保留2位小数。
 *
 *
 * 样例输入
 * 81 4
 * 2 2
 *
 * 样例输出
 * 94.73
 * 3.41
 */
public class 数列和 {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            NumberFormat numberFormat = NumberFormat.getInstance();
            numberFormat.setMaximumFractionDigits(2);
            String scan = scanner.nextLine();
            String[] ss = scan.split(" ");
            int a0 = Integer.parseInt(ss[0]);
            if (a0 == 0) {
                System.out.println(numberFormat.format(a0));
                return;
            }
            int m = Integer.parseInt(ss[1]);

            int i = 0;
            double cur = a0;
            double pre = 0;
            double res = a0;
            while (i < m-1) {
                pre = cur;
                cur = Math.sqrt(pre);
                res += cur;
                i++;
            }


            System.out.println(numberFormat.format(res));
        }
    }
}
