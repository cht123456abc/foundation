import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String str = in.next();


            //
            StringBuilder res = new StringBuilder();
            int n = str.length();
            for (int i = 0; i < n; i++) {
                char c = str.charAt(i);
                if (i + 2 < n && str.charAt(i + 2) == '*') {
                    char dec = (char) (Integer.parseInt(str.substring(i, i + 2)) - 1 + 'a');
                    res.append(dec);
                    i = i + 2;
                } else {
                    char dec = (char) (c - '0' - 1 + 'a');
                    res.append(dec);
                }
            }
            System.out.println(res);
        }
    }
}