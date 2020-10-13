package cn.edu.scu.exam;

import java.util.Scanner;

/**
 * 战术遮挡
 * 时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 * 人的视力不能看到掩体之后的事物，在一场战争中，我们希望对方尽可能的低估我方的战斗力这样才能出其不意。
 *
 * 某个军事参谋效仿孙膑，把某些小规模部队隐藏在大规模部队中，这样，就使得军队数量看起来变少了。
 *
 * 已知，如果某部队A的人数小于等于另一支部队B人数的1/3，则可以将A藏于B中，且不被人发现。不支持嵌套，例如A小于B的三分之一，可将A藏于B，如果又存在B是C的三分之一，不可再将B藏于C。
 *
 * 现在已知我方共有n支部队，且知道每支部队的人数，请问，在最优方案下，我们暴露给敌人的部队数量有几支。
 *
 *
 *
 * 输入描述
 * 输入第一行包含一个正整数n，表示我方有n支部队。(1<=n<=50000)
 *
 * 第二行有n个整数，表示每支部队的人数，中间用空格隔开。(1<=a_i<=10^8)
 *
 * 输出描述
 * 输出仅包含一个整数，表示最少的游戏局数。
 *
 *
 * 样例输入
 * 5
 * 2 6 7 7 10
 * 样例输出
 * 4
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();

            int[] list = new int[n];
            for (int i = 0; i < n; i++) {
                list[i] = scanner.nextInt();
            }


        }

    }



}
