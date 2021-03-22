package cn.edu.scu.exam;

import java.util.Scanner;

/**
 * 懒惰的小美
 * 时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 *        小美有一点懒惰， 她懒得学太多东西和做太多事情。有一次她躺在床上做一项作业时，发现答案都写歪了，请帮她翻转到正确位置。
 *
 *        形式化地，给出一个n×m的二维数组，第 i 行第 j 列的数记为aij。现在要将这个二维数组沿着aii（1≤i≤min（n，m））翻转180°。
 *
 * 例如：
 *
 *
 *
 * 翻转成
 *
 *
 *
 *
 *
 * 输入描述
 * 输入n+1行，第一行两个数n和m，表示二维数组的行数和列数。
 *
 * 接下来n行，每行m个数，第 i 行第 j 个数表示二维数组中的数aij
 *
 * 1≤n,m≤100，0≤aij≤1000000，均为整数
 *
 *
 * 输出描述
 * 输出m行，表示翻转后的二维数组。
 *
 *
 * 样例输入
 * 3 3
 * 1 2 3
 * 4 5 6
 * 7 8 9
 * 样例输出
 * 1 4 7
 * 2 5 8
 * 3 6 9
 */
public class 转置矩阵 {

    public static void main(String[] args) {

        // 转置矩阵
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] A = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                A[i][j] = scanner.nextInt();
            }
        }
//        System.out.println(A);


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(A[j][i]);
            }

        }

    }
}
