package cn.edu.scu.exam;

import java.util.*;

public class 之字型打印 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String str = in.nextLine();

            String[] split = str.split(" ");

            String string = split[0];
            Integer wide = Integer.parseInt(split[1]);

            int n = string.length() / wide + 1;
            char[][] arr = new char[n][wide];

            int dir = 1;
            int k = 0;
            int j = 0;
            for (int i = 0; i < n; i++) {
                while (j >= 0 && j < wide && k < string.length()) {
                    arr[i][j] = string.charAt(k++);
                    j += dir;
                    if (j == wide) {
                        dir = -1;
                        j = wide-1;
                        break;
                    } else if (j < 0) {
                        dir = 1;
                        j = 0;
                        break;
                    }
                }
            }

            k = 0;
            for (j = 0; j < wide; j++) {
                for (int i = 0; i < n; i++) {
                    if(arr[i][j] == '\0') continue;
                    System.out.print(arr[i][j]);
                }
                System.out.println();
            }
        }
    }
}