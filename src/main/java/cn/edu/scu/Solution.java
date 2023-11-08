package cn.edu.scu;

import java.math.BigDecimal;

public class Solution {
    public static void main(String[] args) {

        BigDecimal bigDecimal4 = new BigDecimal(5.554).setScale(1, BigDecimal.ROUND_HALF_DOWN);
        System.out.println("bigDecimal4="+bigDecimal4);
    }
}
