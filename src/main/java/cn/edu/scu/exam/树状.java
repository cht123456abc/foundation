package cn.edu.scu.exam;

import java.util.Scanner;

public class 树状 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            int n = Integer.parseInt(in.nextLine());

            String[] lines = new String[n];
            for (int i = 0; i < n; i++) {
                lines[i] = in.nextLine();
            }

            char root = in.nextLine().charAt(0);

            // 倒排索引
            int[] children = new int[26];

            for (String line : lines) {
                String[] sp = line.split(" ");
                char child = sp[0].charAt(0);
                char parent = sp[1].charAt(0);

                children[parent - 'a'] |= 1 << (child - 'a');
            }

            boolean[] res = new boolean[26];
            search(children,root-'a',res);
            for (int i = 0; i < 26; i++) {
                if (res[i]) {
                    System.out.println((char)('a' + i));
                }

            }

        }
    }

    private static void search(int[] children, int root,boolean[] res) {
        if ((children[root] == 0)) return;
        int k = 0;
        while (k < 26) {
            if (((children[root] >> k) & 1) == 1) {
                res[k] = true;
                search(children,k,res);
            }
            k++;
        }
    }
}
