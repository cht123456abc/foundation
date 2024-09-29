import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            int end = in.nextInt();

            int[][] arr = new int[n][2];
            for (int i = 0; i < n; i++) {
                arr[i][0] = in.nextInt();
                arr[i][1] = in.nextInt();
            }

            //
            int res = 0;
            int y = 0;
            int lastX = 0;
            for (int i = 0; i < n; i++) {
                res += (arr[i][0] - lastX) * Math.abs(y);
                y = y + arr[i][1];
                lastX = arr[i][0];
            }
            res += (end - lastX) * Math.abs(y);
            System.out.println(res);
        }
    }
}