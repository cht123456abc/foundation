package cn.edu.scu.exam;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class 密码验证合格程序 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别

        Pattern pattern = Pattern.compile("(.{3,}).*?\\1");
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String line = in.nextLine();

            String res = "NG";
            int n = line.length();
            if (n < 8) {
                System.out.println(res);
                continue;
            }

            boolean lowC = false,highC = false,digit = false,other = false;
            int typeNum = 0;
            for (int i = 0; i < n; i++) {
                char c = line.charAt(i);
                if (!lowC && Character.isLowerCase(c)) {
                    lowC = true;
                    typeNum++;
                } else if (!highC && Character.isUpperCase(c)) {
                    highC = true;
                    typeNum++;
                } else if (!digit && Character.isDigit(c)) {
                    digit = true;
                    typeNum++;
                } else if (!other && String.valueOf(c).matches("[^\\w\\d\\s]")) {
                    other = true;
                    typeNum++;
                }
            }

            Matcher matcher = pattern.matcher(line);
            if (typeNum < 3 || matcher.find()) {
                System.out.println(res);
                continue;
            }

            System.out.println("OK");
        }

    }
}
