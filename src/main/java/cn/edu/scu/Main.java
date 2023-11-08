package cn.edu.scu;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int h = in.nextInt();

            // 落地5次总路程
            double s = h;
            for (int i = 0; i < 4; i++) {
                s += h * Math.pow(0.5, i);
            }
            // 第5次弹起高度
            double h5 = h * Math.pow(0.5, 5);

            System.out.println(new BigDecimal(s).setScale(6, RoundingMode.HALF_UP));
            System.out.println(new BigDecimal(h5).setScale(6, RoundingMode.HALF_UP));
        }
    }

}
