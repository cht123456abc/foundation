import java.util.Scanner;

/**
 * 自从学习了计算机编程，小明就彻底爱上了0和1，很多01串经常在他脑子里面浮现。
 *
 * 但是他从小就害怕警察，虽然他并没有犯过啥大错误，最多就是在小花的新衣服上画朵小花，在小红的白裙子上点上几个小红点......所以他很害怕110。
 *
 * 现在给你一个01串，请你编写一个程序计算在这个01串中不包含110的最长子串的长度。
 *
 *
 *
 * 输入描述
 * 单组输入。
 *
 * 输入一行，包含一个01串S（在S中只包含0和1，有可能输入全为0或者1的串），其长度1<=|S|<=1000000。
 *
 * 输出描述
 * 输出01串S中不包含110的最长子串的长度。
 *
 *
 * 样例输入
 * 1101010110010110
 * 样例输出
 * 8
 *
 * 提示
 * 在样例中，第2个字符到第9个字符组成的子串10101011为不包含110的最长子串，其长度为8。
 */
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            System.out.println(s);

            int res = 1;
            int n = s.length();

            for (int i = 0; i < n-1; i++) {

            }
        }
    }


}
