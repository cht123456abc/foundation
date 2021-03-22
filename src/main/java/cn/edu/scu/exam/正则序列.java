package cn.edu.scu.exam;

import javax.sound.sampled.Line;
import java.util.Arrays;
import java.util.Scanner;

/**
 * [编程题]正则序列
 * 时间限制：C/C++ 1秒，其他语言2秒
 *
 * 空间限制：C/C++ 256M，其他语言512M
 *
 * 我们称一个长度为n的序列为正则序列，当且仅当该序列是一个由1~n组成的排列，即该序列由n个正整数组成，取值在[1,n]范围，且不存在重复的数，同时正则序列不要求排序
 *
 * 有一天小团得到了一个长度为n的任意序列，他需要在有限次操作内，将这个序列变成一个正则序列，每次操作他可以任选序列中的一个数字，并将该数字加一或者减一。
 *
 * 请问他最少用多少次操作可以把这个序列变成正则序列？
 *
 *
 * 输入描述:
 * 输入第一行仅包含一个正整数n，表示任意序列的长度。(1<=n<=20000)
 *
 * 输入第二行包含n个整数，表示给出的序列，每个数的绝对值都小于10000。
 *
 *
 * 输出描述:
 * 输出仅包含一个整数，表示最少的操作数量。
 *
 *
 * 输入例子1:
 * 5
 * -1 2 3 10 100
 *
 * 输出例子1:
 * 103
 */
public class 正则序列 {

    // 先排序，后进行操作
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }

        Arrays.sort(A);

        int res = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] != i+1) {
                res += i+1-A[i];

            }

        }
        System.out.println(res);

    }
}
